package softuni.exam.instagraphlite.models.dtos;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="picture")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostPictureDto {
    @XmlElement(name="path")
    private String path;

    /**
     *  A char sequence. Cannot be null. The path is unique.
     */
    @NotBlank
    public String getPath() {
        return path;
    }

}
