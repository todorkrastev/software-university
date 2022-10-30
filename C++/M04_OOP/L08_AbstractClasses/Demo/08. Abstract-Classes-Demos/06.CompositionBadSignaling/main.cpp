#include <iostream>

#include "Car.h"

int main() {
  constexpr auto startWheelAngle = 0;
  constexpr auto speed = 50;
  Car car(startWheelAngle, speed);

  constexpr auto turnAngle = 45;
  while (!car.hasMadeFullTurn()) {
    car.turnWheel(turnAngle);
    std::cout << car.toString() << std::endl;
  }

  std::cout << "Car stopped - " << car.toString() << std::endl;

  return 0;
}
