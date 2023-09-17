package bg.manhattan.gira.model.entity;

import bg.manhattan.gira.model.entity.enums.Progress;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
    /**
     * Name length must be between 3 and 20 characters (inclusive 3 and 20).
     */
    @Column(nullable = false, length = 21)
    private String name;

    /**
     * Description min length must be minimum 5(inclusive) characters
     */
    @Column(nullable = false)
    private String description;

    /**
     * Option between (OPEN, IN_PROGRESS, COMPLETED, OTHER)
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Progress progress;

    /**
     * A date, that cannot be in the past
     */
    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @ManyToOne(optional = false)
    private Classification classification;

    @ManyToOne(optional = false)
    private User user;

    public String getName() {
        return name;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public Progress getProgress() {
        return progress;
    }

    public Task setProgress(Progress progress) {
        this.progress = progress;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Task setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Classification getClassification() {
        return classification;
    }

    public Task setClassification(Classification classification) {
        this.classification = classification;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Task setUser(User user) {
        this.user = user;
        return this;
    }
}
