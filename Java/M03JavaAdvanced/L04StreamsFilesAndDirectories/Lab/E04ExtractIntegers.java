package bg.softuni.java_advanced.streams_files_and_directories.lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class E04ExtractIntegers {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("input.txt");
        Scanner scanner = new Scanner(inputStream);
        FileWriter writer = new FileWriter("output.txt");

        while (scanner.hasNext()){
            if(scanner.hasNextInt()) {
                int number = scanner.nextInt();
                writer.write(String.valueOf(number));
                writer.write(System.lineSeparator());
            }
            scanner.next();
        }
        writer.flush();
        writer.close();
    }
}
