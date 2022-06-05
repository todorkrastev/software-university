package io.github.todorkrastev.pathfinder.model.view;

import io.github.todorkrastev.pathfinder.model.entity.enums.LevelName;

public class UserViewModel {

    private Long id;
    private String fullName;
    private String username;
    private Integer age;
    private LevelName level;

    public UserViewModel() {
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
}
