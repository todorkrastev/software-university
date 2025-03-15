package craftsmanLab.models;

public class Craftsman {
    public String name;
    public double hourlyRate;
    public double totalEarnings;

    public Craftsman(String name, double hourlyRate, double totalEarnings) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.totalEarnings = totalEarnings;
    }

    public String getName() {
        return name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void addEarnings(double earnings) {
        this.totalEarnings += earnings;
    }

    @Override
    public String toString() {
        return "Craftsman{" +
                "name='" + name + '\'' +
                ", hourlyRate=" + hourlyRate +
                ", totalEarnings=" + totalEarnings +
                '}';
    }
}
