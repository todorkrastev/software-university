#include "BaseHero.h"

BaseHero::BaseHero(VitalData vitalData, std::string const& name) {
  _vitalData = vitalData;
  _name = name;
}

void BaseHero::takeDamage(int damage) {
  ++_currentDefenceRound;
  int modifiedDamage = applyDefenceBonus(damage, _currentDefenceRound);
  _vitalData.health -= modifiedDamage;
  std::cout << _name << " took " << modifiedDamage << " damage and is left with "
            << _vitalData.health << " health" << std::endl;
}

void BaseHero::regenerate() {
  int regained = _vitalData.manaRegenRate;

  if (_vitalData.currMana + regained > _vitalData.maxMana) {
    regained = _vitalData.maxMana - _vitalData.currMana;
  }
  _vitalData.currMana += regained;
  std::cout << _name << " regained " << regained << " mana for up to "
            << _vitalData.currMana << std::endl;
}

bool BaseHero::isDead() const {
  return _vitalData.health <= 0;
}

int BaseHero::castSpell() {
  ++_currentAttackRound;
  SpellData spell = getSpell();
  _vitalData.currMana -= spell.manaCost;
  std::cout << _name << " casting " << spell.name << " for "
            << spell.manaCost << " mana" << std::endl;

  return applyAttackBonus(spell.damage, _currentAttackRound);
}

void BaseHero::readSpellFromInput(SpellType spellType) {
  SpellDefines spellDefines = WEAKER_SPELL;
  SpellData spell{ };
  std::cin >> spell.name >> spell.damage;
  if (spellType == SpellType::Strong) {
    std::cin >> spell.manaCost;
    spellDefines = STRONGER_SPELL;
  }
  _spells[spellDefines] = spell;
}

SpellData BaseHero::getSpell() const {
  if (_spells[STRONGER_SPELL].manaCost <= _vitalData.currMana) {
    return _spells[STRONGER_SPELL];
  }
  return _spells[WEAKER_SPELL];
}

int BaseHero::applyAttackBonus(int damage, int forRound) const {
  return damage;
}

int BaseHero::applyDefenceBonus(int damage, int forRound) const {
  return damage;
}
