package softuni.exam.domain.entities;

import softuni.exam.domain.entities.enums.Position;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="players")
public class Player extends BaseEntity{

    /**
     * A string (required).
     */
    @Column(name="first_name", nullable = false)
    private String firstName;

    /**
     * A string (required) between 3 and 15 characters.
     */
    @Column(name = "last_name", length = 15)
    private String lastName;

    /**
     * A Integer (required) between 1 and 99.
     */
    @Column(nullable = false)
    private int number;

    /**
     * A Bigdecimal (required) min 0.
     */
    @Column(nullable = false)
    private BigDecimal    salary;

    /**
     * A ENUM (required).
     */
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Position position;

    /**
     * A Picture entity (required).
     */
    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    private Picture picture;

    /**
     * A Team entity (required).
     */
    @ManyToOne(optional = false)
    private Team team;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
