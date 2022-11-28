#include "CommandExecutor.h"

#include <iostream>

void CommandExecutor::executeCommands(const FieldData &fieldData,
                                      const std::vector<Command> &commands) {
  _field.populateField(fieldData);

  for (const Command &command : commands) {
    switch (command.type) {
    case CommandType::POWER_UP:
      bombPowerUp();
      break;

    case CommandType::POWER_DOWN:
      bombPowerDown();
      break;

    case CommandType::PLACE_BOMB:
      placeBomb(command.bombRow, command.bombCol);
      break;

    default:
      std::cerr << "Received invalid command type: "
                << static_cast<int>(command.type) << std::endl;
      break;
    }
  }
}

void CommandExecutor::bombPowerUp() {
  _bomberMan.bombPowerUp();
  std::cout << "Increased bomb power to " << _bomberMan.getBombPower()
            << std::endl;
}

void CommandExecutor::bombPowerDown() {
  _bomberMan.bombPowerDown();
  std::cout << "Decreased bomb power to " << _bomberMan.getBombPower()
            << std::endl;
}

void CommandExecutor::placeBomb(int bombRow, int bombCol) {
  const int score =
      _bomberMan.placeBomb(_field.getFieldData(), bombRow, bombCol);
  std::cout << score << " points" << std::endl;
}

