#include "Wheel.h"
#include "Car.h"

#include <sstream>

Wheel::Wheel(int angle, Car* car) : _angle(angle), _car(car) {

}

void Wheel::turn(int angle) {
  _angle += angle;

  constexpr auto fullRotation = 360;
  if (fullRotation == _angle) {
    _car->setFullTurn(true);
  }
}

std::string Wheel::toString() const {
  std::ostringstream stream;
  stream << "Wheel angle: " << _angle;
  return stream.str();
}
