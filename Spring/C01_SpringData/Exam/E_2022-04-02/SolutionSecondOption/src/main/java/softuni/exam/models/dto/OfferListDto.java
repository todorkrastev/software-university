package softuni.exam.models.dto;

import java.math.BigDecimal;

public class OfferListDto {
    private long id;
    private BigDecimal price;
    private String agentFirstName;
    private String agentLastName;
    private double apartmentArea;
    private String apartmentTownTownName;

    public void setId(long id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAgentFirstName(String agentFirstName) {
        this.agentFirstName = agentFirstName;
    }

    public void setAgentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
    }

    public void setApartmentArea(double apartmentArea) {
        this.apartmentArea = apartmentArea;
    }

    public void setApartmentTownTownName(String apartmentTownTownName) {
        this.apartmentTownTownName = apartmentTownTownName;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Agent %s %s with offer №%d:", agentFirstName, agentLastName, id))
                .append(System.lineSeparator());
        stringBuilder.append(String.format("\t-Apartment area: %.2f", apartmentArea)).append(System.lineSeparator());
        stringBuilder.append(String.format("\t--Town: %s", apartmentTownTownName)).append(System.lineSeparator());
        stringBuilder.append(String.format("\t---Price: %.2f$", price));
        return stringBuilder.toString();
    }
}
