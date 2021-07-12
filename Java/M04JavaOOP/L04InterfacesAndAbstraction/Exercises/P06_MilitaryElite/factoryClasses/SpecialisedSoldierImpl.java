package bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.factoryClasses;

import bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.enumeration.Corps;
import bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private final Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return this.corps.getCorps();
    }

    @Override
    public String toString() {
        return String.format("%s%nCorps: %s", super.toString(), this.getCorps());
    }
}
