#ifndef COMMANDEXECUTOR_H_
#define COMMANDEXECUTOR_H_

#include "Field.h"
#include "BomberMan.h"

class CommandExecutor {
public:
  void executeCommands(const FieldData &fieldData,
                       const std::vector<Command> &commands);

private:
  void bombPowerUp();

  void bombPowerDown();

  void placeBomb(int bombRow, int bombCol);

  Field _field;
  BomberMan _bomberMan;
};

#endif /* COMMANDEXECUTOR_H_ */
