#ifndef CONSOLE_H_
#define CONSOLE_H_

#include <iostream>

class Console {
public:
  Console(int price, int quality)
      : _price(price), _quality(quality) {
  }

  Console(const Console& other) = default;

  Console& operator=(const Console& other) = default;

  int getPrice() const {
    return _price;
  }

  int getQuality() const {
    return _quality;
  }

protected:
  void print() const {
    std::cout << "price: " << _price << ", quality: " << _quality << std::endl;
  }

private:
  int _price;
  int _quality;
};

#endif /* CONSOLE_H_ */
