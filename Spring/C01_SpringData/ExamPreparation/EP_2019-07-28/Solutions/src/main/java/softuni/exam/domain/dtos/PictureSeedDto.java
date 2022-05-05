package softuni.exam.domain.dtos;

import softuni.exam.util.MessageName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="picture")
@XmlAccessorType(XmlAccessType.FIELD)
@MessageName(name = "picture")
public class PictureSeedDto {
    @XmlElement(name="url")
    private String url;

    /**
     *  A string (required).
     */
    @NotBlank
    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return url;
    }
}
