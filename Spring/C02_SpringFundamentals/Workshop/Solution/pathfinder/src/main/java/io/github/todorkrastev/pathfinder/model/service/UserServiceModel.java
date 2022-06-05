package io.github.todorkrastev.pathfinder.model.service;

import io.github.todorkrastev.pathfinder.model.entity.Role;
import io.github.todorkrastev.pathfinder.model.entity.enums.LevelName;

import java.util.Set;

public class UserServiceModel {

    private Long id;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private Integer age;
    private LevelName level;
    private Set<Role> roles;

    public UserServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LevelName getLevel() {
        return level;
    }

    public void setLevel(LevelName level) {
        this.level = level;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
