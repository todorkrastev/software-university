#include "Food.h"

#include <iostream>

int main() {
  Food food{ };

  int linesCount = 0;
  std::cin >> linesCount;

  for (int i = 0; i < linesCount; ++i) {
    std::string command;
    std::cin >> command;

    if (command == "cook") {
      std::string type, size;
      double price;
      std::cin >> type >> size >> price;
      food.cook(type, size, price);
    } else if (command == "sell") {
      int index;
      std::cin >> index;
      food.sell(index);
    } else if (command == "copy") {
      int indexTo, indexFrom;
      std::cin >> indexFrom >> indexTo;
      food.copy(indexFrom, indexTo);
    }
  }

  return 0;
}
