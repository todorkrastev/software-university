package bg.softuni.java_advanced.streams_files_and_directories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class E03AllCapitals {
    private static final String INPUT_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
    private static final String OUTPUT_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line.toUpperCase());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
