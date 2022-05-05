package softuni.exam.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="teams")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamSeedRootDto {
    @XmlElement(name="team")
    private final List<TeamSeedDto> teams;

    public TeamSeedRootDto() {
        this.teams = new ArrayList<>();
    }

    public List<TeamSeedDto> getTeams() {
        return teams;
    }
}
