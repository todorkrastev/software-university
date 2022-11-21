#ifndef HERO_H_
#define HERO_H_

#include <vector>
#include "Defines.h"
#include "Structs.h"

class Hero
{
public:
	Hero() = delete;

	Hero(const std::string& name,
		const int maxMana,
		const int baseManaRegenRate) {
		_name = name;
		_maxMana = maxMana;
		_currMana = maxMana;
		_manaRegenRate = baseManaRegenRate;
	}

	virtual ~Hero() = default;

	virtual void castSpell(const SpellType spell) = 0;

	virtual void regenerateMana() = 0;

	virtual void generateSpells() = 0;

protected:
	std::vector<Spell> _spells;
	std::string        _name;
	int				   _maxMana;
	int 		       _currMana;
	int			       _manaRegenRate;
};

#endif /* HERO_H_ */
