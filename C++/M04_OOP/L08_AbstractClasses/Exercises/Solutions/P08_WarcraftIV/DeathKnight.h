#ifndef DEATHKNIGHT_H_
#define DEATHKNIGHT_H_

#include "Hero.h"

class DeathKnight : public Hero {
public:
	DeathKnight() = delete;

	DeathKnight(const std::string& name,
		const int           maxMana,
		const int           baseManaRegenRate);

	virtual ~DeathKnight() = default;

	virtual void castSpell(const SpellType spell) override;

	virtual void regenerateMana() override;

private:

	virtual void generateSpells() override {
		_spells = { { "Death Coil"  ,  75 } ,
					{ "Animate Dead", 200 } };
	}
};

#endif /* DEATHKNIGHT_H_ */
