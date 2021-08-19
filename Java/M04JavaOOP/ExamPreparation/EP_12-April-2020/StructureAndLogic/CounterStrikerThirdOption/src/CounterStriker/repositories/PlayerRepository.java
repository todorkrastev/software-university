package CounterStriker.repositories;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.players.Player;

public class PlayerRepository extends RepositoryImpl<Player> {
    @Override
    public void add(Player model) {
        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_PLAYER_REPOSITORY);
        }
        super.getModels().add(model);
    }

    @Override
    public Player findByName(String name) {
        return this.getModels().stream().filter(player -> player.getUsername().equals(name)).findFirst().orElse(null);
    }
}
