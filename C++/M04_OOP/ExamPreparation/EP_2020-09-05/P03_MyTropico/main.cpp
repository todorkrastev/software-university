#include <sstream>

#include "Tropico.h"

int main() {
  int lineCount = 0;
  std::cin >> lineCount;
  std::cin.ignore();

  Tropico tropico;

  for (int i = 0; i < lineCount; ++i) {
    std::string input, command;
    getline(std::cin, input);

    std::istringstream istr{ input };
    istr >> command;

    if (command == "build") {
      std::string type;
      int width, length;
      istr >> type >> width >> length;
      tropico.build(type, width, length);
    } else if (command == "duplicate") {
      int firstIndex, secondIndex;
      istr >> firstIndex >> secondIndex;
      tropico.duplicate(firstIndex, secondIndex);
    } else if (command == "replace") {
      int firstIndex, secondIndex;
      istr >> firstIndex >> secondIndex;
      tropico.replace(firstIndex, secondIndex);
    } else if (command == "demolish") {
      int index;
      istr >> index;
      tropico.demolish(index);
    }
  }

  return 0;
}
