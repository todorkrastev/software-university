package bg.softuni.java_advanced.streams_files_and_directories.lab;

import java.io.*;

public class E03CopyBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("input.txt");

        FileOutputStream outputStream = new FileOutputStream("output.txt");

        PrintWriter writer = new PrintWriter(outputStream);

        int singleByte;
        while ((singleByte = inputStream.read()) >= 0) {
            char symbol = (char) singleByte;
            if (singleByte == 10 || singleByte == 32) {
                writer.print(symbol);
            } else {
                writer.print(singleByte);
            }
        }
        inputStream.close();
        writer.close();
    }
}
