package com.manhattan.models.productsShop;

import com.manhattan.models.productsShop.dtos.UserSoldDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSoldRootDto {

    @XmlElement(name="user")
    private List<UserSoldDto> users;

    public UserSoldRootDto(List<UserSoldDto> users) {
        this.users = users;
    }

    public UserSoldRootDto() {
    }
}
