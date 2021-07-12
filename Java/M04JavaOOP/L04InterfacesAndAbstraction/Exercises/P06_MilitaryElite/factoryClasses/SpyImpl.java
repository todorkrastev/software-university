package bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.factoryClasses;

import bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {

    private final String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return String.format("%s%nCode Number: %s", super.toString(), this.getCodeNumber());
    }
}
