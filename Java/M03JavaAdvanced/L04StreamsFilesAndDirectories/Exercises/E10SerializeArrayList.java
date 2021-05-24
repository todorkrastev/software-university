package bg.softuni.java_advanced.streams_files_and_directories.exercises;

import java.io.*;
import java.util.List;

public class E10SerializeArrayList {
    private static final String PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\list.ser";

    public static void main(String[] args) {
        List<Double> list = List.of(4.5, 3.7, 1.0, 8.8);
        try (FileOutputStream fileOutputStream = new FileOutputStream(PATH);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(list);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try (FileInputStream fileInputStream = new FileInputStream(PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            List<Double> deserializedList = (List<Double>) objectInputStream.readObject();

            deserializedList
                    .forEach(System.out::println);
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
