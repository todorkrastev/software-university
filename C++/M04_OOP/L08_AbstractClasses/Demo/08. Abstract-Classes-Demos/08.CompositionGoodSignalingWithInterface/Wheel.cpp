#include "Wheel.h"
#include "CarInterface.h"

#include <sstream>

Wheel::Wheel(int angle, CarInterface *carInterface)
    : _angle(angle), _carInterface(carInterface) {

}

void Wheel::turn(int angle) {
  _angle += angle;

  constexpr auto fullRotation = 360;
  if (fullRotation == _angle) {
    _carInterface->setFullTurn(true);
  }
}

std::string Wheel::toString() const {
  std::ostringstream stream;
  stream << "Wheel angle: " << _angle;
  return stream.str();
}
