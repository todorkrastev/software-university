#include "Glock.h"

Glock::Glock(const int damagePerRound,
			 const int clipSize,
			 const int remainingAmmo) : Pistol(damagePerRound,
										       clipSize,
										       remainingAmmo) {

}

bool Glock::fire(PlayerVitalData & enemyPlayerData) {
	const int HEALTH_ARMOR_MODIFIER = _damagePerRound / 2;

	for(int i = 0; i < ROUNDS_PER_FIRE; ++i) {
		if(0 == _currClipBullets) {
			Pistol::reload();
			return false;
		}

		enemyPlayerData.armor -= HEALTH_ARMOR_MODIFIER;

		//damage bigger that armor ->
		//reduce the remaining damage from health
		if(0 > enemyPlayerData.armor) {
			enemyPlayerData.health += enemyPlayerData.armor;
			enemyPlayerData.armor = 0;
		}

		enemyPlayerData.health -= HEALTH_ARMOR_MODIFIER;

		--_currClipBullets;

		std::cout << "Enemy left with: "
				  << enemyPlayerData.health << " health and "
				  << enemyPlayerData.armor << " armor\n";

		if(0 >= enemyPlayerData.health) {
			return true;
		}
	}

	return false;
}
