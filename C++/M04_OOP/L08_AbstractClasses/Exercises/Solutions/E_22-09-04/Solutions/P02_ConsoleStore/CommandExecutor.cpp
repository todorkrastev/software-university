#include "CommandExecutor.h"

#include <sstream>
#include <iostream>

void CommandExecutor::extractCommand(const std::string &commandStr) {
  std::istringstream istr(commandStr);
  int currCommandInt = 0;
  int consoleTypeInt = 0;
  istr >> currCommandInt >> consoleTypeInt;
  const CommandType command = static_cast<CommandType>(currCommandInt);
  const ConsoleType console = static_cast<ConsoleType>(consoleTypeInt);

  switch (command) {
  case CommandType::ADD: {
    int price = 0;
    int quality = 0;
    istr >> price >> quality;

    if (ConsoleType::PS == console) {
      int generation = 0;
      istr >> generation;
      executeAddPs(price, quality, generation);
    } else {
      executeAddXbox(price, quality);
    }
  }
    break;

  case CommandType::REMOVE:
    executeRemove(console);
    break;

  case CommandType::SORT_BY_PRICE:
    executeSortByPrice(console);
    break;

  case CommandType::SORT_BY_QUALITY:
    executeSortByQuality(console);
    break;

  case CommandType::PRINT:
    executePrint(console);
    break;

  default:
    std::cerr << "Warning, received unknown CommandType: " << consoleTypeInt
              << std::endl;
    break;
  }
}

void CommandExecutor::executeAddPs(int price, int quality, int generation) {
  _store.addPs(price, quality, generation);
}

void CommandExecutor::executeAddXbox(int price, int quality) {
  _store.addXbox(price, quality);
}

void CommandExecutor::executeRemove(ConsoleType consoleType) {
  _store.remove(consoleType);
}

void CommandExecutor::executeSortByPrice(ConsoleType consoleType) {
  _store.sortByPrice(consoleType);
}

void CommandExecutor::executeSortByQuality(ConsoleType consoleType) {
  _store.sortByQuality(consoleType);
}

void CommandExecutor::executePrint(ConsoleType consoleType) {
  _store.print(consoleType);
}

