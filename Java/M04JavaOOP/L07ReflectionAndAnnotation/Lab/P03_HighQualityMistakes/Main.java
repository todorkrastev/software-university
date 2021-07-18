package bg.softuni.java_oop.reflection_and_annotation.lab.P03_HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> myClass = Class.forName("Reflection");
        Field[] fields = myClass.getDeclaredFields();

        Field[] field = Arrays
                .stream(fields)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .toArray(Field[]::new);

        Arrays
                .stream(field)
                .forEach(f -> System.out.printf("%s must be private!%n", f.getName()));

        Method[] methods = myClass.getDeclaredMethods();

        Method[] getters = Arrays
                .stream(methods)
                .filter(method -> !Modifier.isPublic(method.getModifiers()) &&
                        method.getName().startsWith("get") &&
                        method.getReturnType() != void.class)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays
                .stream(getters)
                .forEach(getter -> System.out.printf("%s have to be public!%n", getter.getName()));

        Method[] setters = Arrays
                .stream(methods)
                .filter(method -> !Modifier.isPrivate(method.getModifiers()) &&
                        method.getName().startsWith("set") &&
                        method.getReturnType() == void.class)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays
                .stream(setters)
                .forEach(setter -> System.out.printf("%s have to be private!", setter.getName()));
    }
}
