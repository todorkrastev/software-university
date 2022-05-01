package softuni.exam.instagraphlite.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class Post extends BaseEntity{
    /**
     * A char sequence. Cannot be null.
     * Must be at least 21 characters, inclusive.
     */
    @Column(nullable = false)
    private String caption;

    /**
     * A User. Cannot be null.
     */
    @ManyToOne(optional = false)
    private User user;

    /**
     * A Picture. Cannot be null.
     */
    @ManyToOne(optional = false)
    private Picture picture;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
