package entities.p04_HospitalDatabase;

import entities.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity {
    private String comments;
    private LocalDate date;
    private Set<Patient> patientSet;

    public Visitation() {
        this.patientSet = new HashSet<>();
    }

    @Column(name = "comments", columnDefinition = "TINYTEXT")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(name = "date")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @ManyToMany(mappedBy = "visitationSet")
    public Set<Patient> getPatientSet() {
        return patientSet;
    }

    public void setPatientSet(Set<Patient> patients) {
        this.patientSet = patients;
    }
}
