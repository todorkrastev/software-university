package exam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="shops")
public class Shop extends BaseEntity {

    /**
     * Accepts char sequences as values where their character length value higher than or equal to 4.
     * The values are unique in the database.
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * Accepts number values that are more than or equal to 20000.
     */
    @Column(nullable = false)
    private BigDecimal income;

    /**
     * Accepts char sequences as values where their character length value higher than or equal to 4.
     */
    @Column(nullable = false)
    private String address;

    /**
     * accepts number values that are between 1 and 50
     * (Larger than or equal to 1 and less than or equal to 50).
     */
    @Column(name="employee_count", nullable = false)
    private int  employeeCount;

    /**
     * Accepts number values that are more than or equal to 150.
     */
    @Column(name="shop_area")
    private int shopArea;

    @ManyToOne(optional = false)
    private Town town;

    public Shop() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public int getShopArea() {
        return shopArea;
    }

    public void setShopArea(int shopArea) {
        this.shopArea = shopArea;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
