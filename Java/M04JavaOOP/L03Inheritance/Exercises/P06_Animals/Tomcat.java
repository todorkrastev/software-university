package bg.softuni.java_oop.inheritance.exercises.P06_Animals;

public class Tomcat extends Cat {

    protected final static String TOMCAT_GENDER = "Male";

    public Tomcat(String name, int age) {
        super(name, age, TOMCAT_GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
