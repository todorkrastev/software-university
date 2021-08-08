package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Map<Integer, Computer> computers ;
    private Map<Integer, Component> components ;
    private Map<Integer, Peripheral> peripherals;


    public ControllerImpl() {
        this.computers = new HashMap<>();
        this.components = new HashMap<>();
        this.peripherals = new HashMap<>();
    }

    @Override
    public String addComputer(String computerType,
                              int id,
                              String manufacturer,
                              String model,
                              double price) {

        checkComputerMustNotExist(id);
        checkIsValidComputerType(computerType);

        Computer computer = computerType.equals("Laptop")
                ? new Laptop(id, manufacturer, model, price)
                : new DesktopComputer(id, manufacturer, model, price);

        computers.put(id, computer);

        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id,
                                String peripheralType,
                                String manufacturer,
                                String model,
                                double price,
                                double overallPerformance,
                                String connectionType) {

        checkComputerShouldExist(computerId);
        checkPeripheralMustNotExist(id);

        Peripheral peripheral;

        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;

            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }

        computers.get(computerId).addPeripheral(peripheral);
        peripherals.put(id, peripheral);

        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }


    @Override
    public String removePeripheral(String peripheralType, int computerId) {

        checkComputerShouldExist(computerId);
        Peripheral exist = computers.get(computerId).removePeripheral(peripheralType);
        peripherals.remove(exist.getId());

        return String.format(REMOVED_PERIPHERAL, peripheralType, exist.getId());
    }

    @Override
    public String addComponent(int computerId,
                               int id,
                               String componentType,
                               String manufacturer,
                               String model,
                               double price,
                               double overallPerformance,
                               int generation) {

        checkComputerShouldExist(computerId);
        checkComponentMustNotExist(id);

        Component component;
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }

        computers.get(computerId).addComponent(component);
        components.put(id, component);

        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }


    @Override
    public String removeComponent(String componentType, int computerId) {

        checkComputerShouldExist(computerId);
        Component component = computers.get(computerId).removeComponent(componentType);
        computers.remove(component.getId());
        return String.format(REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {

        checkComputerShouldExist(id);
        Computer computer = computers.get(id);
        computers.remove(id);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {

        List<Computer> sorted = computers.values().stream().filter(e -> e.getPrice() <= budget)
                .sorted(Comparator.comparing(Computer::getOverallPerformance).reversed())
                .collect(Collectors.toList());

        if (sorted.isEmpty()) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }
        computers.remove(sorted.get(0).getId());
        return sorted.get(0).toString();
    }

    @Override
    public String getComputerData(int id) {

        checkComputerShouldExist(id);

        return computers.get(id).toString();
    }

    private void checkComputerShouldExist(int id) {

        if (!computers.containsKey(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
    }

    private void checkIsValidComputerType(String type) {

        if (!type.equals("Laptop") && !type.equals("DesktopComputer")) {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
    }

    private void checkComputerMustNotExist(int id) {

        if (computers.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
    }

    private void checkComponentMustNotExist(int id) {

        if (components.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }
    }

    private void checkPeripheralMustNotExist(int id) {

        if (peripherals.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
    }
}