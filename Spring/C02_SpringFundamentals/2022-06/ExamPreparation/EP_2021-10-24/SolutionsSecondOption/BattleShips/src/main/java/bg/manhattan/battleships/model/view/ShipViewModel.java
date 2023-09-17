package bg.manhattan.battleships.model.view;

public class ShipViewModel {
    Long id;
    private String name;
    private Long health;
    private Long power;
    private String ownerName;

    public ShipViewModel(Long id, String name, Long health, Long power, String ownerName) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.power = power;
        this.ownerName = ownerName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getHealth() {
        return health;
    }

    public Long getPower() {
        return power;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        return String.format("| %s | Health: %d | Power: %d |", name, health, power);
    }
}
