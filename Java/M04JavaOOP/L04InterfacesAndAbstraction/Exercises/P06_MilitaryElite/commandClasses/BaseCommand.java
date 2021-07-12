package bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.commandClasses;

import bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.interfaces.Command;
import bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.interfaces.Soldier;

import java.util.List;

public abstract class BaseCommand implements Command {

    private final List<Soldier> soldiers;

    protected BaseCommand(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    protected List<Soldier> getSoldier() {
        return this.soldiers;
    }

    public void add(Soldier soldier) {
        this.soldiers.add(soldier);
    }
}
