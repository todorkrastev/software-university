#include "BattleField.h"

#include "Barbarian.h"
#include "Amazon.h"

void BattleField::createHeroes() {
  _heroes.push_back(
      std::unique_ptr<Hero>(new Barbarian(Hero::readDataFromInput())));
  _heroes.push_back(
      std::unique_ptr<Hero>(new Amazon(Hero::readDataFromInput())));
}

void BattleField::createSpells() {
  const std::vector <SpellType> spellTypes{SpellType::Weak, SpellType::Strong};
  for (auto& hero: _heroes) {
    for (const auto& spellType: spellTypes) {
      hero->readSpellFromInput(spellType);
    }
  }
}

void BattleField::startBattle() {
  auto& attacker = _heroes[0];
  auto& defender = _heroes[1];
  int turnCounter = 0;

  while (true) {
    std::cout << "\n===== Staring turn " << ++turnCounter << " ====="
              << std::endl;

    const int damage = attacker->castSpell();
    defender->takeDamage(damage);
    if (defender->isDead()) {
      printWinner(attacker);
      break;
    }
    attacker->regenerate();
    std::swap(attacker, defender);
  }
}

void BattleField::printWinner(const std::unique_ptr <Hero>& hero) {
  std::cout << hero->getName() << " has won!" << std::endl;
}

