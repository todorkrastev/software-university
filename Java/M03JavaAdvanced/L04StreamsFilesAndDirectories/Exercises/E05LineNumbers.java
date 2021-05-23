package bg.softuni.java_advanced.streams_files_and_directories.exercises;

import java.io.*;

public class E05LineNumbers {
    private static final String INPUT_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
    private static final String OUTPUT_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String line;
            int count = 1;
            while ((line = reader.readLine()) != null) {
                line = count + ". " + line;
                writer.println(line);
                count++;
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
