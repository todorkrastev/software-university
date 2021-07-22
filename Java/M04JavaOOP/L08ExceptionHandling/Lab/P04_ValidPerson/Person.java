package bg.softuni.java_oop.exception_handling.P04_ValidPerson;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        Validator.validateName(firstName, "first");
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    private void setLastName(String lastName) {
        Validator.validateName(lastName, "last");
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        Validator.validateAge(age);
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %s at the age of %d has been successfully saved in the system.", this.getFirstName(), this.getLastName(), this.getAge()).trim();
    }
}
