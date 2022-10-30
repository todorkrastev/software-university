#ifndef DESERTEAGLE_H_
#define DESERTEAGLE_H_

#include "Pistol.h"

class DesertEagle : public Pistol {
	public:
		DesertEagle(const int damagePerRound,
				    const int clipSize,
				    const int remainingAmmo);

		virtual ~DesertEagle() = default;

		virtual bool fire(PlayerVitalData & enemyPlayerData) override;
};

#endif /* DESERTEAGLE_H_ */
