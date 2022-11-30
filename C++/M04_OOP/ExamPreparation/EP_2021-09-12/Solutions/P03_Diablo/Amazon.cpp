#include "Amazon.h"

int Amazon::applyAttackBonus(int damage, int forRound) const {
  if (forRound % AMAZON_PASSIVE_ABILITY_COUNTER == 0) {
    damage += damage / (100 / AMAZON_DAMAGE_INCREASE_PERCENT);
  }
  return damage;
}
