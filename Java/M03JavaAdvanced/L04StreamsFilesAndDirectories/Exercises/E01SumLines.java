package bg.softuni.java_advanced.streams_files_and_directories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class E01SumLines {
    private static final String PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {

            String line;
            while ((line = reader.readLine()) != null) {
                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                System.out.println(sum);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
