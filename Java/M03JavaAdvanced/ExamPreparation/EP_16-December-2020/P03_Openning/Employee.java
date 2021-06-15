package bg.softuni.java_advanced.preparation_exam_16_12_2020.P03_Openning;

public class Employee {
    public String name;
    public int age;
    public String country;

    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s, %d (%s)", getName(), getAge(), getCountry());
    }
}

