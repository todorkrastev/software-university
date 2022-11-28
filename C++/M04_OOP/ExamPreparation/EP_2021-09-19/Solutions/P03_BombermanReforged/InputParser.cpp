#include "InputParser.h"

#include <iostream>
#include <sstream>


FieldData InputParser::readField() const {
  size_t rows, cols;
  std::cin >> rows >> cols;
  FieldData fieldData(rows);
  for (size_t i = 0; i < rows; ++i) {
    std::cin >> fieldData[i];
  }
  return fieldData;
}

std::vector<Command> InputParser::readCommands() const {
  std::vector<Command> commands{ };
  size_t commandsSize;
  std::cin >> commandsSize;
  for (size_t i = 0; i < commandsSize; ++i) {
    Command command{ };
    std::string commandStr;
    std::getline(std::cin >> std::ws, commandStr);

    if (commandStr == "power up") {
      command.type = CommandType::POWER_UP;
    } else if (commandStr == "power down") {
      command.type = CommandType::POWER_DOWN;
    } else if (commandStr.find_first_of("bomb") == 0) {
      command.type = CommandType::PLACE_BOMB;
      std::istringstream istr(commandStr);
      std::string currentCommandStr;
      istr >> currentCommandStr >> command.bombRow >> command.bombCol;
    }

    commands.emplace_back(command);
  }

  return commands;
}
