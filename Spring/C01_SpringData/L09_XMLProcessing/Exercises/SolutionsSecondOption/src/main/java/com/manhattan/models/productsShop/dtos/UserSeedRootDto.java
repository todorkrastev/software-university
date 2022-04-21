package com.manhattan.models.productsShop.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name="users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSeedRootDto {
    @XmlElement(name="user")
    private Set<UserSeedDto> users;

    public UserSeedRootDto() {
        this.users = new HashSet<>();
    }

    public Set<UserSeedDto> getUsers() {
        return users;
    }
}
