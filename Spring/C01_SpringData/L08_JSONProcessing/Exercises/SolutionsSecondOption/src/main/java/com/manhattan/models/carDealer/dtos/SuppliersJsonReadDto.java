package com.manhattan.models.carDealer.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;

public class SuppliersJsonReadDto {
    @Expose
    private String name;
    @Expose
    private boolean isImporter;

    @Size(min=1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
