package tripadministratorjava;

public class Trip {

    public String id;
    public int peopleLimit;
    public Transportation transportation;
    public int price;

    public Trip(String id, int peopleLimit, Transportation transportation, int price) {
        this.id = id;
        this.peopleLimit = peopleLimit;
        this.transportation = transportation;
        this.price = price;
    }
}
