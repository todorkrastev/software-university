package bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.commandClasses;

import bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.enumeration.Corps;
import bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.factoryClasses.SoldierFactory;
import bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.interfaces.Soldier;

import java.util.List;

public class CommandoCommand extends BaseCommand {
    public CommandoCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        if (Corps.isValidCorps(args.get(4))) {
            super.add(SoldierFactory.produceCommando(args));
        }
    }
}
