package bg.softuni.java_oop.working_with_abstraction.lab.P03_StudentSystem;

public class Student {
    private final String name;
    private final int age;
    private final double grade;

    public Student(String[] info) {
        this.name = info[1];
        this.age = Integer.parseInt(info[2]);
        this.grade = Double.parseDouble(info[3]);
    }

    @Override
    public String toString() {
        return String.format("%s is %s years old. %s", getName(), getAge(), getGradeInfo());
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getGrade() {
        return grade;
    }

    public String getGradeInfo() {
        if (getGrade() >= 5.00) {
            return "Excellent student.";
        } else if (getGrade() >= 3.50) {
            return "Average student.";
        }
        return "Very nice person.";
    }
}
