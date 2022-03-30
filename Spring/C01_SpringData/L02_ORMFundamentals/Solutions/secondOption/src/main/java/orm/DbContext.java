package orm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface DbContext <E>{
    boolean persist(E entity) throws IllegalAccessException, SQLException;
    Iterable<E> find(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    Iterable<E> find(Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    E findFirst(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    E findFirst(Class<E> table, String where) throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
    void doCreate(Class<?> entityClass) throws SQLException;
    void doAlter(Class<?> entityClass) throws SQLException;

    int doDelete(Class<E> table) throws SQLException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException;

    int doDelete(Class<E> table, String where) throws SQLException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException;
}
