package bg.softuni.java_advanced.streams_files_and_directories.lab;

import java.io.*;

public class E05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        String line = reader.readLine();

        int lineNum = 1;

        while (line != null) {
            lineNum++;
            line = reader.readLine();

            if (lineNum % 3 == 0) {
                writer.write(line);
                writer.newLine();
            }
        }
        writer.close();
    }
}
