package com.manhattan.dtos;

import com.google.gson.annotations.Expose;

public class EmployeeDetailsDto extends EmployeeDto{
    @Expose
    String managerLastName;

    public String getManagerLastName() {
        return managerLastName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    @Override
    public String toString() {
        return String.format("%s - Manager: %s",
                super.toString(),
                managerLastName == null ? "[no manager]" : managerLastName);
    }
}
