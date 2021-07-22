package bg.softuni.java_oop.exception_handling.P05_CustomException;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        setName(name);
        setEmail(email);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        Validator.ValidateName(name);
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    private void setEmail(String email) {
        Validator.ValidateEmail(email);
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Student with name %s and email %s has been successfully saved in the system.", this.getName(), this.getEmail());
    }
}
