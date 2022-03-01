package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "batches")
public class ProductionBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate createdAt;

    public ProductionBatch(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public ProductionBatch() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
