package bg.softuni.java_oop.reflection_and_annotation.lab.P01_Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws
            ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        Class<?> myClass = Class.forName("Reflection");
        // Second option
        // Class<Reflection> myClass = Reflection.class;

        String type = myClass.getTypeName();
        System.out.println("class " + type);

        Class<?> superClassType = myClass.getSuperclass();
        System.out.println(superClassType);

        Class<?>[] myClassInterfaces = myClass.getInterfaces();
        for (Class<?> myClassInterface : myClassInterfaces) {
            System.out.println(myClassInterface);
        }

        Reflection reflection = (Reflection) myClass.getDeclaredConstructor().newInstance();
        System.out.println(reflection);
    }
}
