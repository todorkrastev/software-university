package CounterStriker.core;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.common.OutputMessages;
import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;
import CounterStriker.repositories.RepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private RepositoryImpl<Gun> guns;
    private RepositoryImpl<Player> players;
    private Field field;

    public ControllerImpl() {
        this.setGuns();
        this.setPlayers();
        this.setField();
    }

    private void setGuns() {
        this.guns = new GunRepository();
    }

    private void setPlayers() {
        this.players = new PlayerRepository();
    }

    private void setField() {
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name, bulletsCount);
                break;
            case "Rifle":
                gun = new Rifle(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_TYPE);
        }
        this.guns.add(gun);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gunByGivenName = this.guns.findByName(gunName);
        if (gunByGivenName == null) {
            throw new NullPointerException(ExceptionMessages.GUN_CANNOT_BE_FOUND);
        }
        Player player;
        switch (type) {
            case "Terrorist":
                player = new Terrorist(username, health, armor, gunByGivenName);
                break;
            case "CounterTerrorist":
                player = new CounterTerrorist(username, health, armor, gunByGivenName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }
        this.players.add(player);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        List<Player> alivePlayers = this.players.getModels().stream().filter(Player::isAlive).collect(Collectors.toList());
        return this.field.start(alivePlayers);
    }

    @Override
    public String report() {
        StringBuilder output = new StringBuilder();
        this.players
                .getModels()
                .stream()
                .sorted(Comparator.comparing(player -> player.getClass().getSimpleName()))
                .sorted(Comparator.comparing(Player::getHealth)
                        .thenComparing(Player::getUsername))
                .forEach(player -> output.append(player).append(System.lineSeparator()));
        return output.toString().trim();
    }
}
