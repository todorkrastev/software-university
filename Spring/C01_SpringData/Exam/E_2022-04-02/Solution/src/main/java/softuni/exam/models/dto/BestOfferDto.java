package softuni.exam.models.dto;

import java.math.BigDecimal;

public class BestOfferDto {

    private String firstName;
    private String lastName;
    private Long id;
    private BigDecimal price;
    private Double area;
    private String townName;

    public BestOfferDto(String firstName, String lastName, Long id, BigDecimal price, Double area, String townName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.price = price;
        this.area = area;
        this.townName = townName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    @Override
    public String toString() {
        return String.format("""
                        Agent %s %s with offer №%d:
                        \t-Apartment area: %.2f
                        \t--Town: %s
                        \t---Price: %.2f$
                        """,
                this.getFirstName(),
                this.getLastName(),
                this.getId(),
                this.getArea(),
                this.getTownName(),
                this.getPrice());
    }
}
