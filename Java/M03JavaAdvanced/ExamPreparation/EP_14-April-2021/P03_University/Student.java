package bg.softuni.java_advanced.exam_preparation_14_April_2021.P03_University;

public class Student {
    public String firstName;
    public String lastName;
    public String bestSubject;

    public Student(String firstName, String lastName, String bestSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestSubject = bestSubject;
    }

    public String getFirstName() {
        return this.firstName;
    }


    public String getLastName() {
        return this.lastName;
    }


    public String getBestSubject() {
        return this.bestSubject;
    }


    @Override
    public String toString() {
        return String.format("Student: %s %s, %s", firstName, lastName, bestSubject);
    }
}
