package exam.model.dto;

import exam.util.MessageName;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@MessageName(name = "Laptop")
public class LaptopSeedDto {

    private String macAddress;

    private double cpuSpeed;

    private int ram;

    private int storage;

    private String description;

    private BigDecimal price;

    private String warrantyType;

    private LaptopShopDto shop;


    /**
     * Accepts char sequences as values where their character length value higher than 8.
     * The values are unique in the database.
     */
    @Size(min = 9)
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * Accepts positive floating-point numbers.
     */
    @Positive
    public double getCpuSpeed() {
        return cpuSpeed;
    }

    /**
     * Accepts number values that are more than or equal to 8 and less than or equal to 128
     */
    @Min(8)
    @Max(128)
    public int getRam() {
        return ram;
    }

    /**
     * Accepts number values that are more than or equal to 128 and less than or equal to 1024
     */
    @Min(128)
    @Max(1024)
    public int getStorage() {
        return storage;
    }

    /**
     * A long and detailed description of all known places with
     * a character length value higher than or equal to 10.
     */
    @Size(min = 10)
    public String getDescription() {
        return description;
    }

    /**
     * Accepts a positive number.
     */
    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * the enumeration, one of the following – BASIC, PREMIUM, LIFETIME.
     */
    @Pattern(regexp = "^(BASIC|PREMIUM|LIFETIME)+$")
    public String getWarrantyType() {
        return warrantyType;
    }

    public LaptopShopDto getShop() {
        return shop;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f - %d - %d", macAddress, cpuSpeed, ram, storage);
    }
}
