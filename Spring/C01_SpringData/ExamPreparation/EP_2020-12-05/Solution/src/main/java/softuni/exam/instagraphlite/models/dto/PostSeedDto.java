package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PostSeedDto {

    @XmlElement(name = "caption")
    private String caption;

    @XmlElement(name = "user")
    private UserWithUsernameDto user;

    @XmlElement(name = "picture")
    private PictureWithPathDto picture;

    @NotBlank
    @Size(min = 21)
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @NotNull
    public UserWithUsernameDto getUser() {
        return user;
    }

    public void setUser(UserWithUsernameDto user) {
        this.user = user;
    }

    @NotNull
    public PictureWithPathDto getPicture() {
        return picture;
    }

    public void setPicture(PictureWithPathDto picture) {
        this.picture = picture;
    }
}
