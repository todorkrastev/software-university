package bg.softuni.java_advanced.streams_files_and_directories.lab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class E08NestedFolders {

    public static void main(String[] args) {
        String fileName = "C:/Users/HP/source/repos/JavaAdvanced/src/bg/softuni/java_advanced/streams_files_and_directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";

        File file = new File(fileName);

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(file);

        int count = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles)
                if (nestedFile.isDirectory())
                    dirs.offer(nestedFile);
            count++;
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");
    }
}
