#include "Archmage.h"

#include <iostream>

Archmage::Archmage(const std::string& name,
	const int maxMana,
	const int baseManaRegenRate,
	const int manaRegenModifier) : Hero(name, maxMana, baseManaRegenRate) {
	_manaRegenModifier = manaRegenModifier;
}

void Archmage::castSpell(const SpellType spell) {
	if (_currMana < _spells[spell].manaCost) {
		std::cout << _name << " - not enough mana to cast "
			<< _spells[spell].name << std::endl;
	} else {
		_currMana -= _spells[spell].manaCost;

		std::cout << _name << " casted " << _spells[spell].name << " for "
			<< _spells[spell].manaCost << " mana" << std::endl;

		if (SpellType::ULTIMATE == spell) {
			regenerateMana();
		}
	}
}

void Archmage::regenerateMana() {
	_currMana += (_manaRegenRate * _manaRegenModifier);

	if (_currMana > _maxMana) {
		_currMana = _maxMana;
	}
}



