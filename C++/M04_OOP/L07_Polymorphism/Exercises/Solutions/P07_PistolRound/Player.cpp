#include "Player.h"
#include "Glock.h"
#include "DesertEagle.h"

void Player::buyPistol(const PistolType pistolType,
					   const int        damagePerRound,
					   const int        clipSize,
					   const int        remainingAmmo) {
	if(PistolType::GLOCK == pistolType) {
		_pistol = new Glock(damagePerRound, clipSize, remainingAmmo);
	} else { //PistolType::DESERT_EAGLE == pistolType
		_pistol = new DesertEagle(damagePerRound, clipSize, remainingAmmo);
	}
}

