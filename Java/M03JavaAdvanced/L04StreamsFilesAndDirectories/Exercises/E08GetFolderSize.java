package bg.softuni.java_advanced.streams_files_and_directories.exercises;

import java.io.*;

public class E08GetFolderSize {
    public static final String DIR_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
    public static final String OUTPUT_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\result.txt";

    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            File folder = new File(DIR_PATH);
            File[] files = folder.listFiles();
            int size = 0;

            if (files != null) {
                for (File file : files) {
                    size += file.length();
                }
            }
            writer.println("Folder size: " + size);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
