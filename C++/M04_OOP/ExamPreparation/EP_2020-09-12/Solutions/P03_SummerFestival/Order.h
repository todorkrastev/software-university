#ifndef CPP_ADVANCED_ORDER_H
#define CPP_ADVANCED_ORDER_H

#include <string>
#include <iostream>

class Order {

  std::string type;
  std::string size;
  double price;

public:

  Order();

  Order(std::string type, std::string size, double price);

  Order(const Order& other);

  std::string getType() const;

  std::string getSize() const;

  double getPrice() const;

  void setType(std::string type);

  void setSize(std::string size);

  void setPrice(double price);

  void printOrderInfo();

  Order& operator=(const Order& other);

  ~Order();

};

#endif //CPP_ADVANCED_ORDER_H
