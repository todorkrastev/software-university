package io.github.todorkrastev.pathfinder.model.entity;

import io.github.todorkrastev.pathfinder.model.entity.enums.RoleName;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    private RoleName role;

    public Role() {
    }

    @Enumerated(EnumType.STRING)
    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }
}
