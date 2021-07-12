package bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.commandClasses;

import bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.factoryClasses.SoldierFactory;
import bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.interfaces.Soldier;

import java.util.List;

public class LieutenantGeneralCommand extends BaseCommand {

    public LieutenantGeneralCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        super.add(SoldierFactory.produceLieutenantGeneral(args, this.getSoldier()));
    }
}
