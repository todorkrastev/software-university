package raceManager.models;

public class Athlete {
    public String name;
    public int age;

    public Athlete(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
