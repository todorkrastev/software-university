package exam.model.dto;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownSeedRootDto {

    @XmlElement(name="town")
    private final List<TownSeedDto> towns;

    public TownSeedRootDto() {
        this.towns = new ArrayList<>();
    }

    public List<TownSeedDto> getTowns() {
        return towns;
    }
}
