package bg.softuni.intro.ioc;

public class Crocodile implements Animal{

    private String name;

    @Override
    public String makeNoise() {
        return "Traka Trak";
    }

    @Override
    public String getName() {
        return name;
    }

    public Crocodile setName(String name) {
        this.name = name;
        return this;
    }
}
