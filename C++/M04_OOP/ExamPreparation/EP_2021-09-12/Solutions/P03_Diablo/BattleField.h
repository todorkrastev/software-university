#ifndef CPP_ADVANCED_BATTLEFIELD_H
#define CPP_ADVANCED_BATTLEFIELD_H

#include "Hero.h"
#include <vector>
#include <memory>

class BattleField {
public:
  void createHeroes();

  void createSpells();

  void startBattle();

private:
  std::vector<std::unique_ptr<Hero>> _heroes{ };

  void printWinner(std::unique_ptr<Hero> const& hero);
};

#endif //CPP_ADVANCED_BATTLEFIELD_H
