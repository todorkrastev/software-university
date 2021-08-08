package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public double getOverallPerformance() {
        return this.components.isEmpty() ? super.getOverallPerformance()
                : super.getOverallPerformance() +
                this.components
                        .stream()
                        .mapToDouble(Component::getOverallPerformance)
                        .average()
                        .orElse(0);
    }

    @Override
    public double getPrice() {
        double sumOfComponents = this.components
                .stream()
                .mapToDouble(Component::getPrice)
                .sum();

        double sumOfPeripherals = this.peripherals
                .stream()
                .mapToDouble(Peripheral::getPrice)
                .sum();

        return super.getPrice() + sumOfComponents + sumOfPeripherals;
    }

    @Override
    public void addComponent(Component component) {
        if (this.components.stream().anyMatch(e -> e.getClass().getSimpleName()
                .equals(component.getClass().getSimpleName()))) {

            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,
                    component.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        Component exist = this.components.stream().filter(e -> e.getClass().getSimpleName()
                .equals(componentType)).findFirst().orElse(null);

        if (exist == null) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT,
                    componentType, this.getClass().getSimpleName(), this.getId()));
        }
        this.components.remove(exist);
        return exist;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (this.peripherals.stream().anyMatch(c -> c.getClass().getSimpleName()
                .equals(peripheral.getClass().getSimpleName()))) {

            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL,
                    peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        Peripheral exist = this.peripherals.stream().filter(e -> e.getClass().getSimpleName()
                .equals(peripheralType)).findFirst().orElse(null);

        if (exist == null) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL,
                    peripheralType, this.getClass().getSimpleName(), this.getId()));
        }
        this.peripherals.remove(exist);
        return exist;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(super.toString())
                .append(System.lineSeparator())
                .append(" ")
                .append(String.format(COMPUTER_COMPONENTS_TO_STRING, this.components.size()))
                .append(System.lineSeparator());
        if (!this.components.isEmpty()) {
            components.forEach(component -> output
                    .append("  ")
                    .append(component)
                    .append(System.lineSeparator()));
        }
        output.append(" ")
                .append(String.format(COMPUTER_PERIPHERALS_TO_STRING
                        , this.peripherals.size(),
                        this.getPeripherals()
                                .stream()
                                .mapToDouble(Peripheral::getOverallPerformance)
                                .average()
                                .orElse(0)))
                .append(System.lineSeparator());
        if (!this.peripherals.isEmpty()) {
            peripherals.forEach(peripheral -> output
                    .append("  ")
                    .append(peripheral)
                    .append(System.lineSeparator()));
        }
        return output.toString().trim();
    }
}
