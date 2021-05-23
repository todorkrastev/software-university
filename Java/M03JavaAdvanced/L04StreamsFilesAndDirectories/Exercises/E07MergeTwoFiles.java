package bg.softuni.java_advanced.streams_files_and_directories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class E07MergeTwoFiles {
    public static final String FIRST_INPUT_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
    public static final String SECOND_INPUT_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
    public static final String OUTPUT_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\result.txt";

    public static void main(String[] args) {
        try (BufferedReader firstReader = new BufferedReader(new FileReader(FIRST_INPUT_PATH));
             BufferedReader secondReader = new BufferedReader(new FileReader(SECOND_INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String line;
            while ((line = firstReader.readLine()) != null) {
                writer.println(line);
            }

            while ((line = secondReader.readLine()) != null) {
                writer.println(line);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}