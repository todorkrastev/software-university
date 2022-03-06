package entities.p04_HospitalDatabase;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity {
    private String name;
    private String comments;
    private Set<Patient> patientSet;

    public Diagnose() {
        this.patientSet = new HashSet<>();
    }

    @Column(name = "name", length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "comments", columnDefinition = "TINYTEXT")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @OneToMany(mappedBy = "diagnoseSet")
    public Set<Patient> getPatientSet() {
        return patientSet;
    }

    public void setPatientSet(Set<Patient> patients) {
        this.patientSet = patients;
    }
}
