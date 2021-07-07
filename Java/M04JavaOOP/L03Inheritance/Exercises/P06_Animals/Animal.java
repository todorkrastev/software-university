package bg.softuni.java_oop.inheritance.exercises.P06_Animals;

public class Animal {
    protected String name;
    protected int age;
    protected String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    private void setName(String name) {
        Validator.validateStringInput(name);
        this.name = name;
    }

    private void setAge(int age) {
        Validator.validateAge(age);
        this.age = age;
    }

    private void setGender(String gender) {
        Validator.validateStringInput(gender);
        this.gender = gender;
    }

    public String produceSound() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output
                .append(this.getClass().getSimpleName())
                .append(System.lineSeparator());
        output
                .append(String.format("%s %d %s", this.getName(), this.getAge(), this.getGender()))
                .append(System.lineSeparator());
        output
                .append(produceSound())
                .append(System.lineSeparator());

        return output.toString().trim();
    }
}
