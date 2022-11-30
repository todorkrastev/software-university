#ifndef CPP_ADVANCED_AMAZON_H
#define CPP_ADVANCED_AMAZON_H


#include "BaseHero.h"

class Amazon : public BaseHero {
public:
  Amazon() = delete;

  explicit Amazon(VitalData vitalData) : BaseHero(vitalData, AMAZON_NAME) { };

  int applyAttackBonus(int damage, int forRound) const override;
};


#endif //CPP_ADVANCED_AMAZON_H
