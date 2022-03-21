package bg.softuni.cardealer.models.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Size;

public class SupplierSeedDto {
    @Expose
    private String name;

    @Expose
    private boolean isImporter;

    public SupplierSeedDto() {
    }

    @Size(min = 1)
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
