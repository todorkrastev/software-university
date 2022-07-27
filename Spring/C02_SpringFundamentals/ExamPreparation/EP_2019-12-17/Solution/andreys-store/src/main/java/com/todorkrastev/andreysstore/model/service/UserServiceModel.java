package com.todorkrastev.andreysstore.model.service;

import java.math.BigDecimal;

public class UserServiceModel extends BaseServiceModel {

    private String username;
    private String password;
    private String email;
    private BigDecimal budget;

    public UserServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
