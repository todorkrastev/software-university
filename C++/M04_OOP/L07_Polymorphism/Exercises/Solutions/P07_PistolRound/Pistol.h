#ifndef PISTOL_H_
#define PISTOL_H_

#include "Structs.h"

#include <iostream>

class Pistol {
	public:
		Pistol(const int damagePerRound,
			   const int clipSize,
			   const int remainingAmmo) : _damagePerRound(damagePerRound),
			                              _clipSize(clipSize),
									      _currClipBullets(clipSize),
									      _remainingAmmo(remainingAmmo) {

		}

		virtual ~Pistol() = default;

		virtual bool fire(PlayerVitalData & enemyPlayerData) = 0;

		void reload() {
			if(0 == _remainingAmmo) {
				std::cout << "No ammo left\n";
			} else {
				while((_currClipBullets != _clipSize) && (0 != _remainingAmmo)) {
					--_remainingAmmo;
					++_currClipBullets;
				}

				std::cout << "Reloading...\n"
						  << "currClipBullets: " << _currClipBullets
						  << ", remainingAmmo: " << _remainingAmmo << '\n';
			}
		}

	protected:
		int _damagePerRound;
		int _clipSize;
		int _currClipBullets;
		int _remainingAmmo;
};

#endif /* PISTOL_H_ */
