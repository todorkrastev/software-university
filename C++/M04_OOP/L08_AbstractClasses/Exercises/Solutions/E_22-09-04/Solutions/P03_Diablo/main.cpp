#include "BattleField.h"

int main() {
  BattleField battleField;
  battleField.createHeroes();
  battleField.createSpells();
  battleField.startBattle();

  return EXIT_SUCCESS;
}
