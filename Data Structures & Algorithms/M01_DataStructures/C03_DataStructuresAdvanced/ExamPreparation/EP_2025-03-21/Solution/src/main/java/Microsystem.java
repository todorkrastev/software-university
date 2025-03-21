public interface Microsystem {

    void createComputer(Computer computer);

    boolean contains(int number);

    int count();

    Computer getComputer(int number);

    void remove(int number);

    void removeWithBrand(Brand brand);

    void upgradeRam(int ram, int number);

    Iterable<Computer> getAllFromBrand(Brand brand);

    Iterable<Computer> getAllWithScreenSize(double screenSize);

    Iterable<Computer> getAllWithColor(String color);

    Iterable<Computer> getInRangePrice(double minPrice, double maxPrice);
}
