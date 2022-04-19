package com.manhattan.dtos;

public class ManagerCustomDto extends EmployeeDetailsDto{
    int lastNameLength;

    public int getLastNameLength() {
        return lastNameLength;
    }

    public void setLastNameLength(int lastNameLength) {
        this.lastNameLength = lastNameLength;
    }

    @Override
    public String toString() {
        return String.format("%s - LastNameLength: %d", super.toString(), this.lastNameLength);
    }
}
