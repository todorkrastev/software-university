#include "BaseConsole.h"

void BaseConsole::printToConsole() const {
  std::cout << getDetailsPrefix() << " ";
  Console::print();
}

BaseConsole::BaseConsole(int price, int quality)
    : Console(price, quality) { }
