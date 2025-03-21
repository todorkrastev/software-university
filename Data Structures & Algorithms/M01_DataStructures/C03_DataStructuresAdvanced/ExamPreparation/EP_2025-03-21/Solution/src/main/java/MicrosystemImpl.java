public class MicrosystemImpl implements Microsystem {

    public MicrosystemImpl() {

    }

    @Override
    public void createComputer(Computer computer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(int number) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Computer getComputer(int number) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(int number) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeWithBrand(Brand brand) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void upgradeRam(int ram, int number) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Computer> getAllFromBrand(Brand brand) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Computer> getAllWithScreenSize(double screenSize) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Computer> getAllWithColor(String color) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Computer> getInRangePrice(double minPrice, double maxPrice) {
        throw new UnsupportedOperationException();
    }
}
