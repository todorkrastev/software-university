#ifndef HERO_H_
#define HERO_H_

#include <string>
#include <array>
#include <iostream>
#include <sstream>

#include "Defines.h"
#include "Structs.h"

class Hero {
public:
  Hero() = default;
  virtual ~Hero() = default;

  virtual void readSpellFromInput(SpellType spellType) = 0;

  //returns the produced damage
  virtual int castSpell() = 0;

  virtual void takeDamage(int damage) = 0;

  virtual void regenerate() = 0;

  virtual bool isDead() const = 0;

  std::string getName() const {
    return _name;
  }

  static VitalData readDataFromInput() {
    VitalData data;

    std::string line;
    getline(std::cin, line);
    std::istringstream istr(line);
    istr >> data.health >> data.maxMana >> data.manaRegenRate;
    data.currMana = data.maxMana;

    return data;
  }

protected:
  VitalData _vitalData;
  std::array<SpellData, SPELLS_COUNT> _spells;
  std::string _name;
};

#endif /* HERO_H_ */
