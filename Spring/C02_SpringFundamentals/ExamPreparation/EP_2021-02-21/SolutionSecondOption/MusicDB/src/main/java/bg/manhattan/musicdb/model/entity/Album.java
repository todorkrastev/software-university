package bg.manhattan.musicdb.model.entity;

import bg.manhattan.musicdb.model.entity.enums.Genre;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="albums")
public class Album extends BaseEntity{
    /**
     *  Name length must be between 3 and 20 characters (inclusive 3 and 20).
     */
    @Column(nullable = false)
    private String name;

    /**
     * Image Url length must be minimum 5(inclusive) characters.
     */
    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    /**
     * Description min length must be minimum 5(inclusive) characters
     * The description is a long text field.
     */
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    /**
     * All sold copies of the album
     * Must be a more than 10(inclusive).
     */
    @Column(nullable = false)
    private Integer copies;

    /**
     * Has a Price
     * Price must be a positive number
     */
    @Column(nullable = false)
    private BigDecimal price;

    /**
     * Date that cannot be in the future
     */
    @Column(name="released_date", nullable = false)
    private LocalDate releasedDate;

    /**
     * Name of producer
     * Can be null.
     */
    @Column
    private String producer;

    /**
     * This is just an enumeration, not entity.
     */
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Genre genre;

    /**
     * This is the relation with artists
     */
    @ManyToOne(optional = false)
    private Artist artist;

    @ManyToOne(optional = false)
    private User addedFrom;

    public String getName() {
        return name;
    }

    public Album setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Album setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Album setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public Album setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Album setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public Album setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public Album setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public Album setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public Artist getArtist() {
        return artist;
    }

    public Album setArtist(Artist artist) {
        this.artist = artist;
        return this;
    }

    public User getAddedFrom() {
        return addedFrom;
    }

    public Album setAddedFrom(User addedFrom) {
        this.addedFrom = addedFrom;
        return this;
    }
}
