package softuni.exam.instagraphlite.models.dtos;

import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.models.entities.User;
import softuni.exam.instagraphlite.util.MessageName;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="post")
@XmlAccessorType(XmlAccessType.FIELD)
@MessageName(name="Post")
public class PostSeedDto {

    @XmlElement(name="caption")
    private String caption;

    @XmlElement(name="user")
    private PostUserDto user;

    @XmlElement(name="picture")
    private PostPictureDto picture;

    /**
     * A char sequence. Cannot be null.
     * Must be at least 21 characters, inclusive.
     */
    @NotEmpty
    @Size(min = 21)
    public String getCaption() {
        return caption;
    }

    /**
     * A User. Cannot be null.
     */
    @NotNull
    public PostUserDto getUser() {
        return user;
    }

    /**
     * A Picture. Cannot be null.
     */
    @NotNull
    public PostPictureDto getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return String.format(", made by %s", user.getUsername());
    }
}
