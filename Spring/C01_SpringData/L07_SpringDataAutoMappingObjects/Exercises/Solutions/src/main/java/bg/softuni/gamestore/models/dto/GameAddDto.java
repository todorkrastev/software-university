package bg.softuni.gamestore.models.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class GameAddDto {
    private String title;
    private BigDecimal price;
    private Double size;
    private String trailer;
    private String thumbnailURL;
    private String description;
    private String releaseDate;

    public GameAddDto() {
    }

    public GameAddDto(String title, BigDecimal price, Double size, String trailer,
                      String thumbnailURL, String description, String releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thumbnailURL = thumbnailURL;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    @Pattern(regexp = "[A-Z][a-z]{3,100}",
            message = "Тhe title must begin with a capital letter and contain a minimum of 3 and a maximum of 100 symbols")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // @Min(0)
    @DecimalMin(value = "0",
            message = "The price must be a positive number")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Positive(message = "The size must be a positive number")
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Size(min = 11, max = 11,
            message = "The trailer must be exactly 11 symbols")
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Pattern(regexp = "(http?).+",
            message = "The thumbnail URL must start with http:// or https://")
    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    @Size(min = 20,
            message = "Тhe description must be a minimum of 20 symbols")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
