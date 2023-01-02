#ifndef STRUCTS_H_
#define STRUCTS_H_

#include <string>

struct VitalData {
  int health { 0 };
  int currMana { 0 };
  int maxMana { 0 };
  int manaRegenRate { 0 };
};

struct SpellData {
  std::string name;
  int damage { 0 };
  int manaCost { 0 };
};

#endif /* STRUCTS_H_ */
