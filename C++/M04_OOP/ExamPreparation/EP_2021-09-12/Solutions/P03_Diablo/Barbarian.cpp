#include "Barbarian.h"

int Barbarian::applyDefenceBonus(int damage, int forRound) const {
  if (forRound % BARBARIAN_PASSIVE_ABILITY_COUNTER == 0) {
    damage /= 100 / BARBARIAN_DAMAGE_BLOCK_PERCENT;
  }
  return damage;
}
