package bg.softuni.java_advanced.streams_files_and_directories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class E02WriteToFile {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("input.txt");
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        PrintWriter writer = new PrintWriter(outputStream);

        Set<Character> skipElements = new HashSet<>() {{
            add('!');
            add('?');
            add(',');
            add('.');
        }};

        int singleByte;
        while ((singleByte = inputStream.read()) >= 0) {
            char symbol = (char) singleByte;
            if (!skipElements.contains(symbol)) {
                writer.print(symbol);
            }
        }
        inputStream.close();
        writer.close();
    }
}