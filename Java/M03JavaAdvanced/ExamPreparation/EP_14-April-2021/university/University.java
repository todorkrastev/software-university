package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    private final int capacity;
    private final List<Student> students;


    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
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
                        .append(student.getFirstName())
                        .append(" ")
                        .append(student.getLastName());
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
                    .append(student.getFirstName())
                    .append(" ")
                    .append(student.getLastName());
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
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        this.students
                .forEach(student -> output
                        .append("==Student: First Name = ")
                        .append(student.getFirstName())
                        .append(", Last Name = ")
                        .append(student.getLastName())
                        .append(", Best Subject = ")
                        .append(student.getBestSubject())
                        .append(System.lineSeparator()));
        return output.toString().trim();
    }
}
