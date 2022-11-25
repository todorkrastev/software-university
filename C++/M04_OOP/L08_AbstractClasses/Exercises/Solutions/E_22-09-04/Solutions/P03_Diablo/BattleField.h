#ifndef BATTLEFIELD_H_
#define BATTLEFIELD_H_

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


#endif /* BATTLEFIELD_H_ */ 