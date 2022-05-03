package softuni.exam.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="planes")
public class Plane extends BaseEntity{
    /**
     *  A char sequence (minimum length 5).
     *  The register number is unique.
     */
    @Column(name="register_number",nullable = false, unique = true)
    private String registerNumber;

    /**
     *  Number of passenger (must be positive).
     */
    @Column(nullable = false)
    private int capacity;

    /**
     *  Name of the airline company with min length of 2.
     */
    @Column(nullable = false)
    private String airline;

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
