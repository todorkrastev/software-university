package softuni.exam.instagraphlite.models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    /**
     *  A char sequence. Cannot be null. The username is unique.
     *  Must be between 2 and 18 (both numbers are INCLUSIVE)
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * A char sequence. Cannot be null.
     * Must be at least 4 characters long, inclusive.
     */
    @Column(nullable = false)
    private String password;

    /**
     * A Picture. Cannot be null.
     */
    @ManyToOne
    @JoinColumn(name = "profile_picture_id")
    private Picture profilePicture;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Post> posts;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Picture getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Picture profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
