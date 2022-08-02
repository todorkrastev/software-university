package bg.manhattan.musicdb.model.view;

import bg.manhattan.musicdb.model.entity.enums.ArtistNameEnum;
import bg.manhattan.musicdb.model.entity.enums.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumViewModel {
    private Long id;
    private String name;
    private String imageUrl;
    private ArtistNameEnum artistName;
    private Genre genre;
    private BigDecimal price;
    private LocalDate releasedDate;
    private Integer copies;

    public Long getId() {
        return id;
    }

    public AlbumViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AlbumViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public ArtistNameEnum getArtistName() {
        return artistName;
    }

    public AlbumViewModel setArtistName(ArtistNameEnum artistName) {
        this.artistName = artistName;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public AlbumViewModel setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public AlbumViewModel setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public AlbumViewModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }
}
