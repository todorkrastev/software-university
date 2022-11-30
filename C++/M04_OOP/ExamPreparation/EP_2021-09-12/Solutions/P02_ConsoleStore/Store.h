#ifndef CPP_ADVANCED_STORE_H
#define CPP_ADVANCED_STORE_H


#include "Defines.h"
#include "BaseConsole.h"

#include <vector>
#include <unordered_map>
#include <memory>

class Store {

public:
  Store() = default;

  void addPs(int price, int quality, int generation);

  void addXbox(int price, int quality);

  void remove(ConsoleType consoleType);

  void sortByPrice(ConsoleType consoleType);

  void sortByQuality(ConsoleType consoleType);

  void print(ConsoleType consolePtr);

private:

  void addConsole(std::unique_ptr<BaseConsole> consolePtr);

  std::unordered_map<ConsoleType, std::vector<std::unique_ptr<BaseConsole>>> _store{ };

};


#endif //CPP_ADVANCED_STORE_H
