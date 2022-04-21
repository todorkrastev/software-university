package com.manhattan.models.productsShop.dtos;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlRootElement(name="users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersAndProductsDto {
    @XmlAttribute(name="count")
    private long userCount;

    @XmlElement(name = "user")
    private List<UserAndSoldProductsDto> users;

    public UsersAndProductsDto() {
    }

    public UsersAndProductsDto(List<UserAndSoldProductsDto> users) {
        this.userCount = users.size();
        this.users = users;
    }

    public long getUserCount() {
        return userCount;
    }

    public void setUserCount(long userCount) {
        this.userCount = userCount;
    }

    public List<UserAndSoldProductsDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserAndSoldProductsDto> users) {
        this.users = users;
    }
}
