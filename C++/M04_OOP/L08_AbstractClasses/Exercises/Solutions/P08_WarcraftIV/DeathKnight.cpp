#include "DeathKnight.h"

#include <iostream>

DeathKnight::DeathKnight(const std::string& name,
	const int maxMana,
	const int baseManaRegenRate) :
	Hero(name, maxMana, baseManaRegenRate) {

}

void DeathKnight::castSpell(const SpellType spell) {
	if (_currMana < _spells[spell].manaCost) {
		std::cout << _name << " - not enough mana to cast "
			<< _spells[spell].name << std::endl;
	} else {
		_currMana -= _spells[spell].manaCost;

		std::cout << _name << " casted " << _spells[spell].name << " for "
			<< _spells[spell].manaCost << " mana" << std::endl;

		if (SpellType::ULTIMATE == spell) {
			std::cout << _name << " casted " << _spells[BASIC].name
				<< " for 0 mana" << std::endl;
		}
	}
}

void DeathKnight::regenerateMana() {
	_currMana += _manaRegenRate;

	if (_currMana > _maxMana) {
		_currMana = _maxMana;
	}
}



