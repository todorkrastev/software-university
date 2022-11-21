#include "DrawRanger.h"

#include <iostream>

DrawRanger::DrawRanger(const std::string& name,
	const int maxMana,
	const int baseManaRegenRate) :
	Hero(name, maxMana, baseManaRegenRate) {
}

void DrawRanger::castSpell(const SpellType spell) {
	if (_currMana < _spells[spell].manaCost) {
		std::cout << _name << " - not enough mana to cast "
			<< _spells[spell].name << std::endl;
	} else {
		_currMana -= _spells[spell].manaCost;

		std::cout << _name << " casted " << _spells[spell].name << " for "
			<< _spells[spell].manaCost << " mana" << std::endl;

		if (SpellType::BASIC == spell) {
			std::cout << _name << " casted " << _spells[BASIC].name
				<< " for 0 mana" << std::endl;
		}
	}
}

void DrawRanger::regenerateMana() {
	_currMana += _manaRegenRate;

	if (_currMana > _maxMana) {
		_currMana = _maxMana;
	}
}



