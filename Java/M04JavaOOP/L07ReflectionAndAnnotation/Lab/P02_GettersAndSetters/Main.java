package bg.softuni.java_oop.reflection_and_annotation.lab.P02_GettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws
            ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException,
            NoSuchFieldException {
        Class<?> myClass = Class.forName("Reflection");

        Method[] methods = myClass.getDeclaredMethods();

        Method[] getters = Arrays
                .stream(methods)
                .filter(method -> method.getName().startsWith("get") &&
                        method.getParameterCount() == 0 &&
                        method.getReturnType() != void.class)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        Arrays
                .stream(getters)
                .forEach(method -> System.out.printf("%s will return class %s%n",
                        method.getName(),
                        method.getReturnType().getName()));

        Method[] setters = Arrays
                .stream(methods)
                .filter(method -> method.getName().startsWith("set") &&
                        method.getParameterCount() == 1 &&
                        method.getReturnType() == void.class)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        Arrays
                .stream(setters)
                .forEach(method -> System.out.printf("%s and will set field of class %s%n",
                        method.getName(),
                        method.getParameters()[0].getType().getName()));
    }
}
