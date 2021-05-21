package bg.softuni.java_advanced.streams_files_and_directories.lab;

import java.io.FileInputStream;
import java.io.IOException;

public class E01ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int singleByte;

        while ((singleByte = inputStream.read()) >= 0) {
            System.out.printf("%s ", Integer.toBinaryString(singleByte));
        }
        inputStream.close();
    }
}

