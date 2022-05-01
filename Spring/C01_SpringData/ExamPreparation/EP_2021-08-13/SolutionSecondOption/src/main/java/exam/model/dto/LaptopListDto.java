package exam.model.dto;

import java.math.BigDecimal;

public class LaptopListDto {

    private String macAddress;

    private double cpuSpeed;

    private int ram;

    private int storage;

    private String description;

    private BigDecimal price;

    private String shopName;

    private String shopTownName;

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public void setCpuSpeed(double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setShopTownName(String shopTownName) {
        this.shopTownName = shopTownName;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("Laptop - %s", macAddress)).append(System.lineSeparator());
        sb.append(String.format("*Cpu speed - %.2f", cpuSpeed)).append(System.lineSeparator());
        sb.append(String.format("**Ram - %d", ram)).append(System.lineSeparator());
        sb.append(String.format("***Storage - %d", storage)).append(System.lineSeparator());
        sb.append(String.format("****Price - %.2f", price)).append(System.lineSeparator());
        sb.append(String.format("#Shop name - %s", shopName)).append(System.lineSeparator());
        sb.append(String.format("##Town - %s", shopTownName));
        return sb.toString();
    }
}
