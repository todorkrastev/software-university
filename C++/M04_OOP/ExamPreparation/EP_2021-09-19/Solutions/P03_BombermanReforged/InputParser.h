#ifndef INPUTPARSER_H_
#define INPUTPARSER_H_

#include "Defines.h"

class InputParser {
public:
  FieldData readField() const;

  std::vector<Command> readCommands() const;
};

#endif /* INPUTPARSER_H_ */
