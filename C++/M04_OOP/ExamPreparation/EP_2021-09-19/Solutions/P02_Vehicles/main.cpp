#include <iostream>
#include <string>

#include "CommandExecutor.h"

int main() {
  int commands = 0;
  std::string input;

  std::cin >> commands;
  std::cin.ignore();

  CommandExecutor commandExecutor;

  for (int i = 0; i < commands; ++i) {
    getline(std::cin, input);
    commandExecutor.extractCommand(input);

    if (!commandExecutor.isRaceRunning()) {
      break;
    }
  }
  commandExecutor.printWinner();

  return EXIT_SUCCESS;
}
