#include <iostream>
#include <vector>

#include "Player.h"

int main() {
	std::vector<Player> players;
	players.reserve(PLAYERS_COUNT);

	int playerHealth   = 0;
	int playerArmor    = 0;

	for(int i = 0; i < PLAYERS_COUNT; ++i) {
		std::cin >> playerHealth >> playerArmor;

		players.emplace_back(playerHealth,
				             playerArmor,
							 i);
	}

	int pistolId             = 0;
	int pistolDamagePerRound = 0;
	int pistolClipSize       = 0;
	int pistolRemainingAmmo  = 0;

	for(int i = 0; i < PLAYERS_COUNT; ++i) {
		std::cin >> pistolId >> pistolDamagePerRound
		         >> pistolClipSize >> pistolRemainingAmmo;

		players[i].buyPistol(static_cast<PistolType>(pistolId),
							 pistolDamagePerRound,
							 pistolClipSize,
							 pistolRemainingAmmo);
	}

	while(true) {
		if(players[PLAYER_ONE].fireAtEnemry(players[PLAYER_TWO].getVitalData())) {
			std::cout << "Player with ID: " << PLAYER_ONE << " wins!\n";
			break;
		}

		if(players[PLAYER_TWO].fireAtEnemry(players[PLAYER_ONE].getVitalData())) {
			std::cout << "Player with ID: " << PLAYER_TWO << " wins!\n";
			break;
		}
	}

	return 0;
}
