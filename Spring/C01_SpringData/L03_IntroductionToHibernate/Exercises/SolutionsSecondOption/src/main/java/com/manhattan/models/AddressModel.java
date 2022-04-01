package com.manhattan.models;

public class AddressModel {
    private String addressText;
    private String townName;
    private int employeeCount;

    public AddressModel(String addressText, String townName, int employeeCount) {
        this.addressText = addressText;
        this.townName = townName;
        this.employeeCount = employeeCount;
    }

    @Override
    public String toString() {
        String pluralEmployeeText = employeeCount > 1 ? "employees" : "employee";
        return String.format("%s, %s - %d %s", addressText, townName, employeeCount, pluralEmployeeText);
    }
}
