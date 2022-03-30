import entities.User;
import orm.DbContext;
import orm.EntityManager;
import orm.MyConnector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        MyConnector.createConnection("root", "", "custom-orm");
        Connection connection = MyConnector.getConnection();
        DbContext<User> dbContext = new EntityManager(connection);

//        dbContext.doCreate(User.class);
//
//        List<User> users = List.of(
//                new User("Pesho", 15, LocalDate.now()),
//                new User("Gosho", 25, LocalDate.now()),
//                new User("Dancho", 50, LocalDate.now()),
//                new User("Niki", 35, LocalDate.now()));
//        for (User user : users) {
//            dbContext.persist(user);
//        }
//
//        Iterable<User> usersCollection = dbContext.find(User.class);
//
//        for (User user : usersCollection) {
//            System.out.println(user);
//        }
//
//        System.out.println();
//        System.out.println(dbContext.findFirst(User.class, "id=3"));
//
//        System.out.println();
//        System.out.println(dbContext.findFirst(User.class));
//
//        System.out.println();
//        System.out.println(dbContext.find(User.class, "id=4"));
//        dbContext.doDelete(User.class, "id=3");
        //       dbContext.doAlter(User.class);
        dbContext.persist(new User("Pepi", 46, LocalDate.now()));
        connection.close();


    }
}
