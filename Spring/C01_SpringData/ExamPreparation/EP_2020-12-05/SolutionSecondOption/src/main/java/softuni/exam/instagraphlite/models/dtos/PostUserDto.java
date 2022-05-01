package softuni.exam.instagraphlite.models.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostUserDto {
    @XmlElement(name="username")
    private String username;

    @Size(min = 2, max = 18)
    @NotBlank
    public String getUsername() {
        return username;
    }
}
