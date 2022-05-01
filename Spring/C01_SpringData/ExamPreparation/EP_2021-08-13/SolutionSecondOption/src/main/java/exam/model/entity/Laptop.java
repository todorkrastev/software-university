package exam.model.entity;

import exam.model.entity.enums.WarrantyType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="laptops")
public class Laptop extends BaseEntity {
    /**
     * Accepts char sequences as values where their character length value higher than 8.
     * The values are unique in the database.
     */
    @Column(name = "mac_address", nullable = false, unique = true)
    private String macAddress;

    /**
     * Accepts positive floating-point numbers.
     */
    @Column(name= "cpu_speed", nullable = false)
    private double cpuSpeed;

    /**
     * Accepts number values that are more than or equal to 8 and less than or equal to 128
     */
    @Column(nullable = false)
    private int ram;

    /**
     * Accepts number values that are more than or equal to 128 and less than or equal to 1024
     */
    @Column(nullable = false)
    private int storage;

    /**
     * A long and detailed description of all known places with
     * a character length value higher than or equal to 10.
     */
    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    /**
     * Accepts a positive number.
     */
    @Column(nullable = false)
    private BigDecimal price;

    /**
     * the enumeration, one of the following – BASIC, PREMIUM, LIFETIME.
     */
    @Column(name="warranty_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private WarrantyType warrantyType;

    @ManyToOne(optional = false)
    private Shop shop;

    public Laptop() {
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
