package bg.softuni.java_oop.exception_handling.P05_CustomException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        List<Student> studentList = new ArrayList<>();


        String name;
        while (!"end".equals(name = reader.readLine())) {
            String email = reader.readLine();

            try {
                Student student = new Student(name, email);
                studentList.add(student);
            } catch (InvalidPersonNameException exception) {
                System.out.println("Exception thrown: " + exception.getMessage());
            }
        }
        studentList
                .forEach(student -> System.out.println(student.toString()));
    }
}

