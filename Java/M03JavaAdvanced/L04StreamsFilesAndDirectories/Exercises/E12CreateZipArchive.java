package bg.softuni.java_advanced.streams_files_and_directories.exercises;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class E12CreateZipArchive {
    public static final String FIRST_FILE_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
    public static final String SECOND_FILE_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
    public static final String THIRD_FILE_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
    public static final String ZIP_FILE_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\files.zip";

    public static void main(String[] args) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(ZIP_FILE_PATH))) {
            addToZipFile(FIRST_FILE_PATH, zipOutputStream);
            addToZipFile(SECOND_FILE_PATH, zipOutputStream);
            addToZipFile(THIRD_FILE_PATH, zipOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addToZipFile(String path, ZipOutputStream zipOutputStream) throws IOException {
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);

        String[] tokens = path.split("/");
        String fileName = tokens[tokens.length - 1];

        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOutputStream.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;

        while ((length = fileInputStream.read(bytes)) >= 0) {
            zipOutputStream.write(bytes, 0, length);
        }
        zipOutputStream.closeEntry();
        fileInputStream.close();
    }
}
