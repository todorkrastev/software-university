package barbershopjava;

public class Client {

    public String name;
    public int age;
    public Gender gender;
    public Barber barber;

    public Client(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Barber getBarber() {
        return barber;
    }

    public Client setName(String name) {
        this.name = name;
        return this;
    }

    public Client setAge(int age) {
        this.age = age;
        return this;
    }

    public Client setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Client setBarber(Barber barber) {
        this.barber = barber;
        return this;
    }

    public String getBarberName() {
        return barber.getName();
    }
}
