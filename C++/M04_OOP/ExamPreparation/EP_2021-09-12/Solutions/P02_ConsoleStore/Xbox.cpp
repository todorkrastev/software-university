#include "Xbox.h"

Xbox::Xbox(int price, int quality)
    : BaseConsole(price, quality) { }

ConsoleType Xbox::getConsoleType() const {
  return ConsoleType::XBOX;
}

std::string Xbox::getDetailsPrefix() const {
  return "Xbox with";
}
