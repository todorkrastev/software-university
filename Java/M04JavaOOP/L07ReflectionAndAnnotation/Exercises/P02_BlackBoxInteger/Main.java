package bg.softuni.java_oop.reflection_and_annotation.exercises.P02_BlackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        try {
            Class<BlackBoxInt> clazz = BlackBoxInt.class;

            Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor(int.class);
            constructor.setAccessible(true);
            BlackBoxInt blackBox = constructor.newInstance(0);
            Field field = BlackBoxInt.class.getDeclaredField("innerValue");
            field.setAccessible(true);

            String input;
            while (!"end".equalsIgnoreCase(input = reader.readLine())) {
                String command = input.trim().split("_")[0];
                int parameterType = Integer.parseInt(input.trim().split("_")[1]);

                Method method = clazz.getDeclaredMethod(command, int.class);
                method.setAccessible(true);
                method.invoke(blackBox, parameterType);

                System.out.println(field.get(blackBox));
            }
        } catch (IllegalAccessException
                | InstantiationException
                | NoSuchMethodException
                | InvocationTargetException
                | NoSuchFieldException
                | IOException e) {
            e.printStackTrace();
        }
    }
}
