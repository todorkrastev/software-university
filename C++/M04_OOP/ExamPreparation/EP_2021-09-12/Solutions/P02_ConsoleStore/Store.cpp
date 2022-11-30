#include "Store.h"
#include "Ps.h"
#include "Xbox.h"

#include <algorithm>

std::string getConsoleNameFromType(ConsoleType consoleType);

void Store::addPs(int price, int quality, int generation) {
  addConsole(std::unique_ptr<Ps>(new Ps(price, quality, generation)));
}

void Store::addXbox(int price, int quality) {
  addConsole(std::unique_ptr<Xbox>(new Xbox(price, quality)));
}

void Store::sortByPrice(ConsoleType consoleType) {
  std::cout << "Sorting all " << getConsoleNameFromType(consoleType) << " by price" << std::endl;
  std::sort(_store[consoleType].begin(), _store[consoleType].end(),
            [](const std::unique_ptr<BaseConsole>& first, const std::unique_ptr<BaseConsole>& second) {
              return first->getPrice() > second->getPrice();
            });
}

void Store::sortByQuality(ConsoleType consoleType) {
  std::cout << "Sorting all " << getConsoleNameFromType(consoleType) << " by quality" << std::endl;
  std::sort(_store[consoleType].begin(), _store[consoleType].end(),
            [](const std::unique_ptr<BaseConsole>& first, const std::unique_ptr<BaseConsole>& second) {
              return first->getQuality() > second->getQuality();
            });
}

void Store::print(ConsoleType consoleType) {
  std::cout << "Printing all " << getConsoleNameFromType(consoleType) << " data" << std::endl;
  std::for_each(_store[consoleType].cbegin(), _store[consoleType].cend(),
                [](const std::unique_ptr<BaseConsole>& consolePtr) { consolePtr->printToConsole(); });
}

void Store::remove(ConsoleType consoleType) {
  std::cout << "Removing: ";
  _store[consoleType].back()->printToConsole();
  _store[consoleType].pop_back();
}

void Store::addConsole(std::unique_ptr<BaseConsole> consolePtr) {
  std::cout << "Adding: ";
  consolePtr->printToConsole();
  _store[consolePtr->getConsoleType()].push_back(std::move(consolePtr));
}

std::string getConsoleNameFromType(ConsoleType consoleType) {
  switch (consoleType) {
  case ConsoleType::PS:
    return "PS";
  case ConsoleType::XBOX:
    return "Xbox";
  default:
    return "UNKNOWN";
  }
}
