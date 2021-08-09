package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {

    private final Queue<Gun> gunsQueue;
    private final List<Player> civilPlayers;
    private final Player mainPlayer;
    private final GangNeighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.neighbourhood = new GangNeighbourhood();
        this.gunsQueue = new ArrayDeque<>();
        this.civilPlayers = new ArrayList<>();

    }

    @Override
    public String addPlayer(String name) {

        Player player = new CivilPlayer(name);
        civilPlayers.add(player);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {

        if (type.equals("Pistol") || type.equals("Rifle")) {
            Gun gun = type.equals("Pistol") ? new Pistol(name) : new Rifle(name);
            gunsQueue.offer(gun);
            return String.format(GUN_ADDED, name, type);
        }
        return GUN_TYPE_INVALID;
    }

    @Override
    public String addGunToPlayer(String name) {
        if (gunsQueue.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        } else if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(gunsQueue.peek());
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gunsQueue.poll().getName(), mainPlayer.getName());
        } else if (civilPlayers.stream().noneMatch(p -> p.getName().equals(name))) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        } else {
            civilPlayers.stream().filter(p -> p.getName().equals(name))
                    .findFirst().get().getGunRepository().add(gunsQueue.peek());
            return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gunsQueue.poll().getName(), name);
        }
    }

    @Override
    public String fight() {

        int mainPlayerPoints = mainPlayer.getLifePoints();
        int civilPlayersPoints = civilPlayers.stream().mapToInt(Player::getLifePoints).sum();
        int countPlayers = civilPlayers.size();
        neighbourhood.action(mainPlayer, civilPlayers);
        boolean pointsEquals = civilPlayersPoints == civilPlayers.stream().mapToInt(Player::getLifePoints).sum();

        if (mainPlayerPoints == mainPlayer.getLifePoints() && pointsEquals) {
            return ConstantMessages.FIGHT_HOT_HAPPENED;
        } else {
            StringBuilder output = new StringBuilder();
            output.append(FIGHT_HAPPENED)
                    .append(System.lineSeparator())
                    .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                    .append(System.lineSeparator())
                    .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, countPlayers - civilPlayers.size()))
                    .append(System.lineSeparator())
                    .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, civilPlayers.size()));
            return output.toString();
        }
    }
}
