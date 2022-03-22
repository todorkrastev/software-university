package bg.softuni.productshop.models.dtos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserViewRootWithOneSoldProduct {

    @XmlAttribute(name = "count")
    private long count;

    @XmlElement(name = "user")
    private List<UserViewFirstNameLastNameAgeDto> users;

    public UserViewRootWithOneSoldProduct() {
    }

    public UserViewRootWithOneSoldProduct(List<UserViewFirstNameLastNameAgeDto> users) {
        this.count = users.size();
        this.users = users;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<UserViewFirstNameLastNameAgeDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserViewFirstNameLastNameAgeDto> users) {
        this.users = users;
    }
}
