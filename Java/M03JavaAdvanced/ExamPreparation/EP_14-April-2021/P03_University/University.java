package bg.softuni.java_advanced.exam_preparation_14_April_2021.P03_University;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;


    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }


    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        StringBuilder output = new StringBuilder();
        if (this.students.size() < capacity) {
            if (this.students.contains(student)) {
                output
                        .append("Student is already in the university");
            } else {
                this.students.add(student);
                output.append("Added student ")
                        .append(student.firstName)
                        .append(" ")
                        .append(student.lastName);
            }
        } else {
            output
                    .append("No seats in the university");
        }
        return output.toString();
    }

    public String dismissStudent(Student student) {
        StringBuilder output = new StringBuilder();
        if (this.students.contains(student)) {
            output
                    .append("Removed student ")
                    .append(student.firstName)
                    .append(" ")
                    .append(student.lastName);
            this.students.remove(student);
        } else {
            output
                    .append("Student not found");
        }
        return output.toString();
    }

    public Student getStudent(String firstName, String lastName) {
        return this.students
                .stream()
                .filter(student -> student.firstName.equals(firstName) && student.lastName.equals(lastName))
                .findFirst()
                .orElse(null);
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        this.students
                .forEach(student -> output
                        .append("==Student: First Name = ")
                        .append(student.firstName)
                        .append(", Last Name = ")
                        .append(student.lastName)
                        .append(", Best Subject = ")
                        .append(student.bestSubject)
                        .append(System.lineSeparator()));
        return output.toString().trim();
    }
}