package entities.p04_HospitalDatabase;

import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "medicaments")
public class Medicament extends BaseEntity {
    private String name;
    private Set<Patient> patientSet;

    public Medicament() {
        this.patientSet = new HashSet<>();
    }

    @Column(name = "name", length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "medicamentSet")
    public Set<Patient> getPatientSet() {
        return patientSet;
    }

    public void setPatientSet(Set<Patient> patients) {
        this.patientSet = patients;
    }
}
