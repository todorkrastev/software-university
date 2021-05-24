package bg.softuni.java_advanced.streams_files_and_directories.exercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class E09CopyAPicture {
    private static final String PICTURE_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\picture.jpg";
    private static final String PICTURE_COPY_PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\picture-copy.jpg";

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream(PICTURE_PATH);
             FileOutputStream fileOutputStream = new FileOutputStream(PICTURE_COPY_PATH)) {

            int oneByte;
            while ((oneByte = fileInputStream.read()) != -1) {
                fileOutputStream.write(oneByte);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
