#include "Car.h"

#include <sstream>

Car::Car(int wheelAngle, double speed)
    : _wheel(wheelAngle, this), _speed(speed) {
}

std::string Car::toString() const {
  std::ostringstream stream;
  stream << "speed: " << _speed << ", " << _wheel.toString();
  return stream.str();
}

void Car::turnWheel(int angle) {
  _wheel.turn(angle);
}

bool Car::hasMadeFullTurn() const {
  return _hasMadeFullTurn;
}

void Car::setFullTurn(bool status) {
  _hasMadeFullTurn = status;
}
