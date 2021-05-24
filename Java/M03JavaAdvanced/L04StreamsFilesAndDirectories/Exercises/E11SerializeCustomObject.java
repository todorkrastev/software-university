package bg.softuni.java_advanced.streams_files_and_directories.exercises;

import java.io.*;

public class E11SerializeCustomObject {
    private static final String PATH = "C:\\Users\\HP\\source\\repos\\JavaAdvanced\\src\\bg\\softuni\\java_advanced\\streams_files_and_directories\\exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\list.ser";

    public static void main(String[] args) {
        Course course = new Course("Java Advanced", 200);
        try (FileOutputStream fileOutputStream = new FileOutputStream(PATH);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(course);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try (FileInputStream fileInputStream = new FileInputStream(PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Course deserializedCourse = (Course) objectInputStream.readObject();

            System.out.println(deserializedCourse);

        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    private static class Course implements Serializable {
        private String name;
        private final int studentsCount;

        public Course(String name, int studentsCount) {
            this.name = name;
            this.studentsCount = studentsCount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStudentsCount() {
            return studentsCount;
        }

        @Override
        public String toString() {
            return String.format("%s -> %d", this.getName(), this.getStudentsCount());
        }
    }
}
