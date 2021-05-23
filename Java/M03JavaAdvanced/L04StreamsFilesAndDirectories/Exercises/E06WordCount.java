package bg.softuni.java_advanced.streams_files_and_directories.exercises;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class E06WordCount {
    public static final String WORDS_INPUT_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
    public static final String TEXT_INPUT_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
    public static final String OUTPUT_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\result.txt";

    public static void main(String[] args) {
        try (BufferedReader wordReader = new BufferedReader(new FileReader(WORDS_INPUT_PATH));
             BufferedReader textReader = new BufferedReader(new FileReader(TEXT_INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String[] words = wordReader.readLine().split("\\s+");
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, 0);
            }

            String[] text = textReader.readLine().split("\\s+");
            for (String word : text) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                }
            }
            map
                    .entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .forEach(e -> writer.println(String.format("%s - %d", e.getKey(), e.getValue())));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
