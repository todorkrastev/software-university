package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "planes")
public class Plane extends BaseEntity{

    private String registerNumber;
    private  Integer capacity;
    private String airline;

    @Column(name = "register_number", nullable = false, unique = true)
    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    @Column(name = "capacity", nullable = false)
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Column(name = "airline", nullable = false)
    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
