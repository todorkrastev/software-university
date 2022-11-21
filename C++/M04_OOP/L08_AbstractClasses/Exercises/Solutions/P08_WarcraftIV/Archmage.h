#ifndef ARCHMAGE_H_
#define ARCHMAGE_H_

#include "Hero.h"

class Archmage : public Hero {
public:
	Archmage() = delete;

	Archmage(const std::string& name,
		const int maxMana,
		const int baseManaRegenRate,
		const int manaRegenModifier);

	virtual ~Archmage() = default;

	virtual void castSpell(const SpellType spell) override;

	virtual void regenerateMana() override;

private:
	virtual void generateSpells() override {
		_spells = { { "Water Elemental", 120 },
					{ "Mass Teleport",   180 } };
	}

	int _manaRegenModifier;
};

#endif /* ARCHMAGE_H_ */
