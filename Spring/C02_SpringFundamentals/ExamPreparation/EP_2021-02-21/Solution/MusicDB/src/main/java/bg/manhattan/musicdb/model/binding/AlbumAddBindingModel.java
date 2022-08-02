package bg.manhattan.musicdb.model.binding;

import bg.manhattan.musicdb.model.entity.Artist;
import bg.manhattan.musicdb.model.entity.User;
import bg.manhattan.musicdb.model.entity.enums.ArtistNameEnum;
import bg.manhattan.musicdb.model.entity.enums.Genre;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAddBindingModel {

    /**
     *  Name length must be between 3 and 20 characters (inclusive 3 and 20).
     */
    @NotBlank(message = "Album name is required")
    @Size(min=3, max = 20, message = "Name must be between 3 and 20 characters")
    private String name;

    /**
     * Image Url length must be minimum 5(inclusive) characters.
     */
    @NotBlank(message = "Image URL is required")
    @Size(min = 5, message = "Image url must be more than 5 characters")
    private String imageUrl;

    /**
     * Description min length must be minimum 5(inclusive) characters
     * The description is a long text field.
     */
    @NotBlank(message = "Description is required")
    @Size(min=5, message = "Description length must be more than 5 characters")
    private String description;

    /**
     * All sold copies of the album
     * Must be a more than 10(inclusive).
     */
    @NotNull(message = "Copies is required")
    @Positive(message = "Copies must be positive")
    private Integer copies;

    /**
     * Has a Price
     * Price must be a positive number
     */
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private BigDecimal price;

    /**
     * Date that cannot be in the future
     */
    @NotNull
    @PastOrPresent(message = "Release date cannot be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releasedDate;

    /**
     * Name of producer
     * Can be null.
     */
    private String producer;

    /**
     * This is just an enumeration, not entity.
     */
    @NotNull(message = "You must select genre")
    private Genre genre;

    /**
     * This is the relation with artists
     */
    @NotNull(message = "You must select artist")
    private ArtistNameEnum artist;

    public String getName() {
        return name;
    }

    public AlbumAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AlbumAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public AlbumAddBindingModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public AlbumAddBindingModel setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumAddBindingModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public AlbumAddBindingModel setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public ArtistNameEnum getArtist() {
        return artist;
    }

    public AlbumAddBindingModel setArtist(ArtistNameEnum artist) {
        this.artist = artist;
        return this;
    }
}
