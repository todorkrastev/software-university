package hiberspring.domain.dtos;

import hiberspring.util.MessageName;

import javax.validation.constraints.NotEmpty;

@MessageName(name = "Branch")
public class BranchSeedDto {
    private String name;
    private String town;

    @NotEmpty
    public String getName() {
        return name;
    }

    @NotEmpty
    public String getTown() {
        return town;
    }

    @Override
    public String toString() {
        return name;
    }
}
