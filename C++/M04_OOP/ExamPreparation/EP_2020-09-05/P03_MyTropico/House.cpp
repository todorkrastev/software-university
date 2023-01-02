#include "House.h"

void House::print() {
  std::cout << "Building type: House, measurements: " << this->getWidth() << " x " << this->getLength() << std::endl;
}

House::House(int width, int length) : Building(width, length) {
  this->print();
  std::cout << "| Constructor is called" << std::endl;
}

House::~House() {
  this->print();
  std::cout << "| Destructor is called" << std::endl;
}
