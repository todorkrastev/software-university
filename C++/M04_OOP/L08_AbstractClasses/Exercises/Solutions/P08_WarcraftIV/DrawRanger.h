#ifndef DRAWRANGER_H_
#define DRAWRANGER_H_

#include "Hero.h"

class DrawRanger : public Hero {
public:
	DrawRanger() = delete;

	DrawRanger(const std::string& name,
		const int maxMana,
		const int baseManaRegenRate);

	virtual ~DrawRanger() = default;

	virtual void castSpell(const SpellType spell) override;

	virtual void regenerateMana() override;

private:
	virtual void generateSpells() override {
		_spells = { { "Silence" , 90 } ,
					{ "Charm",   150 } };
	}
};

#endif /* DRAWRANGER_H_ */
