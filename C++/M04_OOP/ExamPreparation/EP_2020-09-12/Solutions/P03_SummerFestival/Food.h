#ifndef CPP_ADVANCED_FOOD_H
#define CPP_ADVANCED_FOOD_H

#include "Order.h"
#include <string>
#include <vector>

class Food {

  std::vector<Order> orders{ };

public:

  Food();

  void cook(std::string type, std::string size, double price);

  void sell(int index);

  void copy(int indexFrom, int indexTo);
};

#endif //CPP_ADVANCED_FOOD_H
