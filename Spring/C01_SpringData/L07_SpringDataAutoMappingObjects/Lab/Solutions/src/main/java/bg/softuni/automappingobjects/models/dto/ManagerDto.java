package bg.softuni.automappingobjects.models.dto;

import java.util.List;

public class ManagerDto extends BasicEmployeeDto{
    private List<EmployeeDto> subordinates;

    public List<EmployeeDto> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<EmployeeDto> subordinates) {
        this.subordinates = subordinates;
    }
}
