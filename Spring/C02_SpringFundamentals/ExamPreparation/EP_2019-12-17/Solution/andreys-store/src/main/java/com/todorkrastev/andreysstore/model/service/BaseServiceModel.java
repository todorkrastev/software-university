package com.todorkrastev.andreysstore.model.service;

import org.springframework.stereotype.Service;

@Service
public abstract class BaseServiceModel {

    private String id;

    public BaseServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
