package bg.softuni.java_advanced.streams_files_and_directories.lab;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class E09Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Serialize - for class must be Serializable !

        List<String> names = new ArrayList<>();

        names.add("Dominique");
        names.add("Shanecè");
        names.add("Charlott");
        names.add("Christine");

        ObjectOutputStream outputStream =
                new ObjectOutputStream((new FileOutputStream("output.txt")));

        outputStream.writeObject(names);

        outputStream.close();

        //Deserialize

        ObjectInputStream inputStream =
                new ObjectInputStream(new FileInputStream("output.txt"));

        List<String> readNames = (List<String>) inputStream.readObject();

        for (String readName : readNames) {
            System.out.println(readName);
        }
    }
}
