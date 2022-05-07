package softuni.exam.models.entity;

import softuni.exam.models.entity.enums.ApartmentType;

import javax.persistence.*;

@Entity
@Table(name="apartments")
public class Apartment extends BaseEntity {
    /**
     * The enumeration, one of the following – two_rooms, three_rooms, four_rooms
     */
    @Column(name="apartment_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ApartmentType apartmentType;

    /**
     * Accepts number values that are more than or equal to 40.00.
     */
    @Column(nullable = false)
    private double area;

    @ManyToOne(optional = false)
    private Town town;

    public Apartment() {
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
