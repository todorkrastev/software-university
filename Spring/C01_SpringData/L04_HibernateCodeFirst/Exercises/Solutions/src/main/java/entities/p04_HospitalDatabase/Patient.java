package entities.p04_HospitalDatabase;

import entities.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private LocalDate dateOfBirth;
    private byte[] picture;
    private Boolean isInsuranceExpired;
    private Set<Visitation> visitationSet;
    private Diagnose diagnoseSet;
    private Set<Medicament> medicamentSet;



    public Patient() {
        this.visitationSet = new HashSet<>();
        this.medicamentSet = new HashSet<>();
    }

    public Patient(byte[] picture) {
        this.picture = picture;
    }

    @Column(name = "first_name", length = 45, nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", length = 45, nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "address", length = 100, nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "email", length = 100, nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "date_of_birth", nullable = false)
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "picture")
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Column(name = "is_insurance_expired")
    public Boolean getInsuranceExpired() {
        return isInsuranceExpired;
    }

    public void setInsuranceExpired(Boolean insuranceExpired) {
        isInsuranceExpired = insuranceExpired;
    }

    @ManyToMany
    public Set<Visitation> getVisitationSet() {
        return visitationSet;
    }

    public void setVisitationSet(Set<Visitation> visitationSet) {
        this.visitationSet = visitationSet;
    }

    @ManyToOne
    public Diagnose getDiagnoseSet() {
        return diagnoseSet;
    }

    public void setDiagnoseSet(Diagnose diagnose) {
        this.diagnoseSet = diagnose;
    }

    @ManyToMany
    public Set<Medicament> getMedicamentSet() {
        return medicamentSet;
    }

    public void setMedicamentSet(Set<Medicament> medicaments) {
        this.medicamentSet = medicaments;
    }
}
