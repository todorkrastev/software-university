package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Gun currentGun;
        boolean finish = false;

        if (!mainPlayer.getGunRepository().getModels().isEmpty()) {
            currentGun = mainPlayer.getGunRepository().getModels().iterator().next();

            while (civilPlayers.iterator().hasNext()) {
                Player civilPlayer = civilPlayers.iterator().next();
                while (civilPlayer.isAlive()) {
                    if (currentGun.canFire()) {
                        civilPlayer.takeLifePoints(currentGun.fire());
                    } else {
                        if (mainPlayer.getGunRepository().remove(currentGun)
                                && !mainPlayer.getGunRepository().getModels().isEmpty()) {
                            currentGun = mainPlayer.getGunRepository().getModels().iterator().next();
                        } else {
                            finish = true;
                            break;
                        }
                    }
                }
                if (!civilPlayer.isAlive()) {
                    civilPlayers.remove(civilPlayer);
                }
                if (finish) {
                    break;
                }
            }
        }

        finish = false;

        for (Player civilPlayer : civilPlayers) {
            if (!civilPlayer.getGunRepository().getModels().isEmpty()) {
                for (Gun gun : civilPlayer.getGunRepository().getModels()) {

                    while (gun.canFire()) {
                        if (mainPlayer.isAlive()) {
                            mainPlayer.takeLifePoints(gun.fire());
                        } else {
                            finish = true;
                            break;
                        }
                    }
                    if (finish) {
                        break;
                    }
                }
                if (finish) {
                    break;
                }
            }
        }
    }
}
