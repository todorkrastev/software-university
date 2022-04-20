package com.manhattan.models.productsShop.dtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UsersAndProductsDto {
    @Expose
    private long userCount;
    @Expose
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
