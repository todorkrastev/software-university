#ifndef GLOCK_H_
#define GLOCK_H_

#include "Pistol.h"

class Glock : public Pistol {
	public:
		Glock(const int damagePerRound,
			  const int clipSize,
			  const int remainingAmmo);

		virtual ~Glock() = default;

		virtual bool fire(PlayerVitalData & enemyPlayerData) override;

	private:
		enum InternalDefines {
			ROUNDS_PER_FIRE = 3
		};
};

#endif /* GLOCK_H_ */
