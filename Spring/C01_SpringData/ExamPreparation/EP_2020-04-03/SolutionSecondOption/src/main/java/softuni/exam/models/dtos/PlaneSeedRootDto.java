package softuni.exam.models.dtos;

import softuni.exam.util.MessageName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "planes")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneSeedRootDto {
    @XmlElement(name = "plane")
    private final List<PlaneSeedDto> planes;

    public PlaneSeedRootDto() {
        this.planes = new ArrayList<>();
    }

    public List<PlaneSeedDto> getPlanes() {
        return planes;
    }
}
