package CounterStriker.models.field;

import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.*;

public class FieldImpl implements Field {

    @Override
    public String start(Collection<Player> players) {
        Collection<Player> contras = players
                .stream()
                .filter(p -> p instanceof CounterTerrorist)
                .collect(Collectors.toList());

        Collection<Player> terrorists = players
                .stream()
                .filter(p -> p instanceof Terrorist)
                .collect(Collectors.toList());

        while (contras.stream().anyMatch(Player::isAlive) && terrorists.stream().anyMatch(Player::isAlive)) {

            terrorists
                    .stream()
                    .filter(Player::isAlive).<Consumer<? super Player>>map(terrorist -> player ->
                            player.takeDamage(terrorist.getGun().fire()))
                    .forEach(contras::forEach);

            contras
                    .stream()
                    .filter(Player::isAlive).<Consumer<? super Player>>map(contraTerrorist -> player ->
                            player.takeDamage(contraTerrorist.getGun().fire()))
                    .forEach(terrorists::forEach);
        }
        return terrorists.stream().anyMatch(Player::isAlive) ? TERRORIST_WINS : COUNTER_TERRORIST_WINS;
    }
}
