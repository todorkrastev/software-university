#ifndef COMMANDEXECUTOR_H_
#define COMMANDEXECUTOR_H_

#include <string>
#include <vector>

#include "Defines.h"

#include "Store.h"

class CommandExecutor {
public:
  void extractCommand(const std::string& commandStr);

private:
  void executeAddPs(int price, int quality, int generation);

  void executeAddXbox(int price, int quality);

  void executeRemove(ConsoleType consoleType);

  void executeSortByPrice(ConsoleType consoleType);

  void executeSortByQuality(ConsoleType consoleType);

  void executePrint(ConsoleType consoleType);

  Store _store;
};

#endif /* COMMANDEXECUTOR_H_ */
