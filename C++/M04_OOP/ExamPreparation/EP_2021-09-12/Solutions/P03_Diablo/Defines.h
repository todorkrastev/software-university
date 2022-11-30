#ifndef DEFINES_H_
#define DEFINES_H_

enum class SpellType {
  Weak,
  Strong
};

enum SpellDefines {
  WEAKER_SPELL = 0,
  STRONGER_SPELL = 1,
  SPELLS_COUNT = 2
};

#define BARBARIAN_NAME "Barbarian"
#define AMAZON_NAME "Amazon"

enum HeroDefines {
  BARBARIAN_PASSIVE_ABILITY_COUNTER = 3,
  BARBARIAN_DAMAGE_BLOCK_PERCENT = 50,

  AMAZON_PASSIVE_ABILITY_COUNTER = 2,
  AMAZON_DAMAGE_INCREASE_PERCENT = 25,
};

#endif /* DEFINES_H_ */
