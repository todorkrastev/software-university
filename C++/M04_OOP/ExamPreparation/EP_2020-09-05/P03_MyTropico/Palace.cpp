#include "Palace.h"

void Palace::print() {
  std::cout << "Building type: Palace, measurements: " << this->getWidth() << " x " << this->getLength() << std::endl;
}

Palace::Palace(int width, int length) : Building(width, length) {
  this->print();
  std::cout << "| Constructor is called" << std::endl;
}

Palace::~Palace() {
  this->print();
  std::cout << "| Destructor is called" << std::endl;
}
