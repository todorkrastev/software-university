package bg.softuni.productshop.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSeedRootDto {

    @XmlElement(name = "user")
    private List<UserSeedDto> users;

    public List<UserSeedDto> getUsers() {
        return users;
    }
}
