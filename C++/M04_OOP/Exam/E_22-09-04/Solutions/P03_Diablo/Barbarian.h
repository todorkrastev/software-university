#ifndef BARBARIAN_H_
#define BARBARIAN_H_

#include "BaseHero.h"

class Barbarian : public BaseHero {
public:
	Barbarian() = delete;

	explicit Barbarian(VitalData vitalData) : BaseHero(vitalData, BARBARIAN_NAME) { };

	int applyDefenceBonus(int damage, int forRound) const override;
};


#endif /* BARBARIAN_H_ */