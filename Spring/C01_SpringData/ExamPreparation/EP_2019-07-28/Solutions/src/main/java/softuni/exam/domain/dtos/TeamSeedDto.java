package softuni.exam.domain.dtos;

import softuni.exam.util.MessageName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="team")
@XmlAccessorType(XmlAccessType.FIELD)
@MessageName(name="team")
public class TeamSeedDto {
    /**
     * A string (required) between 3 and 20 characters.
     */
    @XmlElement(name="name")
    @NotNull
    @Size(min=3, max = 20)
    private String name;

    /**
     * A Picture entity (required).
     */
    @XmlElement(name="picture")
    private TeamPictureDto picture;

    public String getName() {
        return name;
    }

    public TeamPictureDto getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return name;
    }
}
