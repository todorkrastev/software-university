package CounterStriker.models.field;

import CounterStriker.common.OutputMessages;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FieldImpl implements Field {
    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorists = players.stream().filter(player -> player instanceof Terrorist).collect(Collectors.toList());
        List<Player> counterTerrorists = players.stream().filter(player -> player instanceof CounterTerrorist).collect(Collectors.toList());
        while (terrorists.stream().anyMatch(Player::isAlive) && counterTerrorists.stream().anyMatch(Player::isAlive)) {
            for (Player currTerrorist : terrorists) {
                for (Player currCounterTerrorist : counterTerrorists) {
                    int damage = currTerrorist.getGun().fire();
                    currCounterTerrorist.takeDamage(damage);
                }
            }
            counterTerrorists = counterTerrorists.stream().filter(Player::isAlive).collect(Collectors.toList());

            for (Player currCounterTerrorist : counterTerrorists) {
                for (Player currTerrorist : terrorists) {
                    int damage = currCounterTerrorist.getGun().fire();
                    currTerrorist.takeDamage(damage);
                }
            }

            terrorists = terrorists.stream().filter(Player::isAlive).collect(Collectors.toList());
        }

        return counterTerrorists.stream().anyMatch(Player::isAlive) ?
                OutputMessages.COUNTER_TERRORIST_WINS :
                OutputMessages.TERRORIST_WINS;
    }
}
