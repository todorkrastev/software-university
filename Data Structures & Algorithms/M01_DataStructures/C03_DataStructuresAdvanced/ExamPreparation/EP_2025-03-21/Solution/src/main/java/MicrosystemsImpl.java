import java.util.*;
import java.util.stream.Collectors;

public class MicrosystemsImpl implements Microsystems {
    private final Map<Integer, Computer> computers;

    public MicrosystemsImpl() {
        this.computers = new HashMap<>();
    }

    @Override
    public void createComputer(Computer computer) {
        if (computers.containsKey(computer.getNumber())) {
            throw new IllegalArgumentException("Computer with this number already exists.");
        }
        computers.put(computer.getNumber(), computer);
    }

    @Override
    public boolean contains(int number) {
        return computers.containsKey(number);
    }

    @Override
    public int count() {
        return computers.size();
    }

    @Override
    public Computer getComputer(int number) {
        if (!computers.containsKey(number)) {
            throw new IllegalArgumentException("Computer with this number does not exist.");
        }
        return computers.get(number);
    }

    @Override
    public void remove(int number) {
        if (!computers.containsKey(number)) {
            throw new IllegalArgumentException("Computer with this number does not exist.");
        }
        computers.remove(number);
    }

    @Override
    public void removeWithBrand(Brand brand) {
        boolean found = false;
        Iterator<Map.Entry<Integer, Computer>> iterator = computers.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Computer> entry = iterator.next();
            if (entry.getValue().getBrand() == brand) {
                iterator.remove();
                found = true;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("No computers with this brand found.");
        }
    }

    @Override
    public void upgradeRam(int ram, int number) {
        Computer computer = getComputer(number);
        if (computer.getRAM() < ram) {
            computer.setRAM(ram);
        }
    }

    @Override
    public Iterable<Computer> getAllFromBrand(Brand brand) {
        return computers.values().stream()
                .filter(c -> c.getBrand() == brand)
                .sorted(Comparator.comparingDouble(Computer::getPrice).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Computer> getAllWithScreenSize(double screenSize) {
        return computers.values().stream()
                .filter(c -> c.getScreenSize() == screenSize)
                .sorted(Comparator.comparingInt(Computer::getNumber).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Computer> getAllWithColor(String color) {
        return computers.values().stream()
                .filter(c -> c.getColor().equals(color))
                .sorted(Comparator.comparingDouble(Computer::getPrice).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Computer> getInRangePrice(double minPrice, double maxPrice) {
        return computers.values().stream()
                .filter(c -> c.getPrice() >= minPrice && c.getPrice() <= maxPrice)
                .sorted(Comparator.comparingDouble(Computer::getPrice).reversed())
                .collect(Collectors.toList());
    }
}