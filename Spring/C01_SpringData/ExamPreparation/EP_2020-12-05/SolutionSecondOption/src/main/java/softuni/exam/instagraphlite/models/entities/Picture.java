package softuni.exam.instagraphlite.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pictures")
public class Picture extends BaseEntity{
    /**
     *  A char sequence. Cannot be null. The path is unique.
     */
    @Column(nullable = false, unique = true)
    private String path;

    /**
     * A floating point number. Cannot be null. Must be between 500 and 60000 (both numbers are INCLUSIVE)
     */
    @Column(nullable = false)
    private Double size;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
