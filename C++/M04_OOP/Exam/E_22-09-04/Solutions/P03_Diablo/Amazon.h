#ifndef AMAZON_H_
#define AMAZON_H_


#include "BaseHero.h"

class Amazon : public BaseHero {
public:
	Amazon() = delete;

	explicit Amazon(VitalData vitalData) : BaseHero(vitalData, AMAZON_NAME) { };

	int applyAttackBonus(int damage, int forRound) const override;
};


#endif /* AMAZON_H_ */