package bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.factoryClasses;

import bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.interfaces.Private;

public class PrivateImpl extends SoldierImpl implements Private {

    private final double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getsSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("%s Salary: %.2f", super.toString(), this.getsSalary());
    }
}
