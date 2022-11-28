#ifndef DEFINES_H_
#define DEFINES_H_

#include <vector>
#include <string>

enum class CommandType {
  POWER_UP = 0,
  POWER_DOWN,
  PLACE_BOMB,

  UNKNOWN = 255
};

struct Command {
  Command() : type(CommandType::UNKNOWN), bombRow(-1), bombCol(-1) { }

  CommandType type;
  int bombRow;
  int bombCol;
};

using FieldData = std::vector<std::string>;

#endif /* DEFINES_H_ */
