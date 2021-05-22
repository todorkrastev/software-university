package bg.softuni.java_advanced.streams_files_and_directories.lab;

import java.io.File;

public class E07ListFiles {
    public static void main(String[] args) {
        String fileName = "C:/Users/HP/source/repos/JavaAdvanced/src/bg/softuni/java_advanced/streams_files_and_directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";

        File file = new File(fileName);

        File[] innerFiles = file.listFiles();

        for (File innerFile : innerFiles) {
            if (!innerFile.isDirectory()) {
                System.out.printf("%s: [%d]%n", innerFile.getName(), innerFile.length());
            }
        }
    }
}
