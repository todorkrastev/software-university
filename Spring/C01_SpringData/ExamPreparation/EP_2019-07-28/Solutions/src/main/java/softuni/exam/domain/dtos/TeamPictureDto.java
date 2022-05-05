package softuni.exam.domain.dtos;

import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="picture")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamPictureDto {
    @XmlElement(name="url")
    private String url;

    @NotEmpty
    public String getUrl() {
        return url;
    }
}
