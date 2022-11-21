#include <sstream>
#include <iostream>

#include "Archmage.h"
#include "DeathKnight.h"
#include "DrawRanger.h"

#define HEROES_SIZE 3

int main() {
    std::string name;
    int maxMana = 0;
    int baseManaRegenRate = 0;
    int manaRegenModifier = 0;

    std::cin >> name >> maxMana >> baseManaRegenRate >> manaRegenModifier;
    Archmage archmage(name, maxMana, baseManaRegenRate, manaRegenModifier);

    std::cin >> name >> maxMana >> baseManaRegenRate;
    DeathKnight deathKnight(name, maxMana, baseManaRegenRate);

    std::cin >> name >> maxMana >> baseManaRegenRate;
    DrawRanger drawRanger(name, maxMana, baseManaRegenRate);

    std::cin.ignore();

    std::vector<Hero *> heroes(HEROES_SIZE);
    heroes[0] = &archmage;
    heroes[1] = &deathKnight;
    heroes[2] = &drawRanger;

    for(int i = 0; i < HEROES_SIZE; ++i) {
        heroes[i]->generateSpells();
    }

    std::string input;
    getline(std::cin, input);
    std::istringstream sstr(input);
    int currAction = 0;

    while(sstr >> currAction) {
        switch(currAction) {
            case ActionType::CAST_BASIC_SPELL:
                for(int i = 0; i < HEROES_SIZE; ++i) {
                    heroes[i]->castSpell(SpellType::BASIC);
                }
                break;

            case ActionType::CAST_ULTIMATE_SPELL:
                for(int i = 0; i < HEROES_SIZE; ++i) {
                    heroes[i]->castSpell(SpellType::ULTIMATE);
                }
                break;

            case ActionType::REGENERATE_MANA:
                for(int i = 0; i < HEROES_SIZE; ++i) {
                    heroes[i]->regenerateMana();
                }
                break;
        }
    }

    return 0;
}


