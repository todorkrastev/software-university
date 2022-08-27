#include "Echo.h"

bool echoOn = false;

void echo(const std::string& message) {
  if (echoOn) {
    std::cout << message << std::endl;
  }
}
