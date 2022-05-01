package exam.model.dto;

import exam.util.MessageName;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@XmlRootElement(name = "shop")
@XmlAccessorType(XmlAccessType.FIELD)
@MessageName(name = "Shop")
public class ShopSeedDto {

    @XmlElement(name = "address")
    private String address;

    @XmlElement(name = "employee-count")
    private int employeeCount;

    @XmlElement(name = "income")
    private BigDecimal income;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "shop-area")
    private int shopArea;

    @XmlElement(name = "town")
    private ShopTownDto town;

    public ShopSeedDto() {
    }

    /**
     * Accepts char sequences as values where their character length value higher than or equal to 4.
     */
    @Size(min = 4)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * accepts number values that are between 1 and 50
     * (Larger than or equal to 1 and less than or equal to 50).
     */
    @Min(1)
    @Max(50)
    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    /**
     * Accepts number values that are more than or equal to 20000.
     */
    @Min(20000)
    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    /**
     * Accepts char sequences as values where their character length value higher than or equal to 4.
     * The values are unique in the database.
     */
    @Size(min = 4)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accepts number values that are more than or equal to 150.
     */
    @Min(150)
    public int getShopArea() {
        return shopArea;
    }

    public void setShopArea(int shopArea) {
        this.shopArea = shopArea;
    }

    public ShopTownDto getTown() {
        return town;
    }

    public void setTown(ShopTownDto town) {
        this.town = town;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s - %s", this.getName(), df.format(this.getIncome()));
    }
}
