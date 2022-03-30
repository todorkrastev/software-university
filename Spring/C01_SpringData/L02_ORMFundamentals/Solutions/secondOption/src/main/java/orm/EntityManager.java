package orm;

import annotation.Column;
import annotation.Entity;
import annotation.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EntityManager<E> implements DbContext<E> {
    private Connection connection;
    private Map<Type, String> toSQLType = new HashMap<>();

    public EntityManager(Connection connection) {
        this.connection = connection;
        initializeTypes();
    }

    private void initializeTypes() {
        this.toSQLType.put(int.class, "INT");
        this.toSQLType.put(Integer.class, "INT");
        this.toSQLType.put(long.class, "INT");
        this.toSQLType.put(double.class, "DOUBLE");
        this.toSQLType.put(String.class, "VARCHAR(255)");
        this.toSQLType.put(LocalDate.class, "DATE");
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        Field primaryKey = this.getIdColumn(entity.getClass());
        primaryKey.setAccessible(true);
        Object value = primaryKey.get(entity);
        if (value == null || (long) value <= 0) {
            return doInsert(entity, primaryKey);
        }

        return doUpdate(entity, primaryKey);
    }

    @Override
    public Iterable<E> find(Class<E> table) throws SQLException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return find(table, null);
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) throws SQLException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        String tableName = getTableName(table);
        String query = String.format("SELECT * FROM %s "
                        + ((where != null) ? "WHERE %s;" : ";"),
                tableName, where);
        ResultSet resultSet = getResultSet(query, table, where);
        List<E> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(resultSetToEntity(table, resultSet));
        }
        return result;
    }

    @Override
    public E findFirst(Class<E> table) throws SQLException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return findFirst(table, null);
    }

    @Override
    public E findFirst(Class<E> table, String where) throws SQLException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        String tableName = getTableName(table);
        String query = String.format("SELECT * FROM %s " +
                ((where != null) ? "WHERE %s" : "") +
                " LIMIT 1;", tableName, where);
        ResultSet resultSet = getResultSet(query, table, where);
        resultSet.next();
        return resultSetToEntity(table, resultSet);
    }

    @Override
    public void doCreate(Class<?> entityClass) throws SQLException {
        String tableName = getTableName(entityClass);
        String query = String.format("CREATE TABLE %s ( id INT PRIMARY KEY AUTO_INCREMENT, %s);",
                tableName, getAllFieldsAndDataTypes(entityClass));
        PreparedStatement statement = connection.prepareStatement(query);
        statement.execute();
    }

    @Override
    public void doAlter(Class<?> clazz) throws SQLException {
        String tableName = getTableName(clazz);
        String newFields = getNewFields(clazz);
        if (!newFields.trim().isBlank()) {
            String query = String.format("ALTER TABLE %s ADD COLUMN %s;",
                    tableName, newFields);
            connection.prepareStatement(query).executeUpdate();
        }
    }

    @Override
    public int doDelete(Class<E> table) throws SQLException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        return doDelete(table, "");
    }

    @Override
    public int doDelete(Class<E> table, String where) throws SQLException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        String tableName = getTableName(table);
        String query = String.format("DELETE FROM %s " +
                ((where != null) ? "WHERE %s;" : ";"), tableName, where);
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeUpdate();
    }

    private String getNewFields(Class<?> clazz) throws SQLException {
        Set<String> fields = getAllFieldsFromTable(clazz);
        return getColumns(clazz)
                .stream().filter(f -> !fields.contains(f.getAnnotation(Column.class).name()))
                .map(f -> getFieldNameAndDataType(f))
                .collect(Collectors.joining(", "));

    }

    private Set<String> getAllFieldsFromTable(Class<?> clazz) throws SQLException {
        Set<String> allFields = new HashSet<>();
        String query = String.format("SELECT `COLUMN_NAME` FROM INFORMATION_SCHEMA.COLUMNS\n" +
                " WHERE TABLE_SCHEMA = 'custom-orm'" +
                "   AND COLUMN_NAME != 'id'" +
                "   AND TABLE_NAME = '%s'", getTableName(clazz));
        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            allFields.add(resultSet.getString(1));
        }

        return allFields;
    }

    private String getAllFieldsAndDataTypes(Class<?> entityClass) {
        List<Field> columns = getColumns(entityClass);
        return columns.stream()
                .map(c -> getFieldNameAndDataType(c))
                .collect(Collectors.joining(", "));
    }

    private String getFieldNameAndDataType(Field c) {
        return String.format("%s %s", c.getAnnotation(Column.class).name(), toSQLType.get(c.getType()));
    }

    private ResultSet getResultSet(String query, Class<E> table, String where) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

    private E resultSetToEntity(Class<E> table, ResultSet resultSet) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        E entity = table.getDeclaredConstructor().newInstance();
        for (Field field : entity.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            field.set(entity, getProperValue(resultSet, field.getAnnotation(Column.class).name(), field.getType()));
        }
        return entity;
    }

    private <T> T getProperValue(ResultSet resultSet, String name, Class<T> clazz) throws SQLException,
            NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (clazz.isAssignableFrom(LocalDate.class)) {
            return (T) LocalDate.parse(resultSet.getObject(name).toString());
        }
        Object object = resultSet.getObject(name);
        return (T) object;
    }

    private Field getIdColumn(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() ->
                        new UnsupportedOperationException("Entity does not have primary key"));
    }

    private boolean doInsert(E entity, Field primaryKey) throws IllegalAccessException, SQLException {
        String tableName = getTableName(entity.getClass());
        List<Field> fields = getColumns(entity.getClass());
        String columnNames = getColumnNames(fields);
        String columnValues = getColumnValues(fields, entity);
        String insertQuery = String.format("INSERT INTO %s(%s) VALUES(%s)", tableName, columnNames, columnValues);
        return connection.prepareStatement(insertQuery).execute();
    }

    private boolean doUpdate(E entity, Field primaryKey) throws IllegalAccessException, SQLException {
        String tableName = getTableName(entity.getClass());
        List<Field> fields = getColumns(entity.getClass());
        String setColumnValues = getColumnNamesAndValues(fields, entity);
        String updateQuery = String.format("UPDATE %s SET %s WHERE %s = %s",
                tableName, setColumnValues, primaryKey.getName(), primaryKey.get(entity));
        return connection.prepareStatement(updateQuery).execute();
    }

    private List<Field> getColumns(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> !field.isAnnotationPresent(Id.class))
                .filter(field -> field.isAnnotationPresent(Column.class))
                .collect(Collectors.toList());
    }

    private String getTableName(Class<?> clazz) {
        return clazz.getAnnotation(Entity.class).name();
    }

    private String getColumnNames(List<Field> fields) {
        return fields
                .stream()
                .map(field -> field.getAnnotation(Column.class).name())
                .collect(Collectors.joining(","));
    }

    private String getColumnValues(List<Field> fields, E entity) throws IllegalAccessException {
        List<String> values = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(entity);
            String strValue = getStringDependingType(value);
            values.add(strValue);
        }

        return String.join(", ", values);
    }

    private String getColumnNamesAndValues(List<Field> fields, E entity) throws IllegalAccessException {
        List<String> statements = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);
            String columnName = field.getAnnotation(Column.class).name();
            Object value = field.get(entity);
            String strValue = getStringDependingType(value);
            statements.add(String.format("%s = %s", columnName, strValue));
        }
        return String.join(", ", statements);
    }

    private String getStringDependingType(Object value) {
        String strValue = value.toString();
        if ((value instanceof String)
                || (value instanceof LocalDate)) {
            strValue = String.format("'%s'", strValue);
        }
        return strValue;
    }
}
