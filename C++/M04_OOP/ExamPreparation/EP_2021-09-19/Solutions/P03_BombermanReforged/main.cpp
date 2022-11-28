#include "InputParser.h"
#include "CommandExecutor.h"

int main() {
  InputParser inputParser;
  const FieldData fieldData = inputParser.readField();
  const std::vector<Command> commands = inputParser.readCommands();

  CommandExecutor commandExecutor;
  commandExecutor.executeCommands(fieldData, commands);

  return EXIT_SUCCESS;
}

