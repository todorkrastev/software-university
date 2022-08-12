#include "Wheel.h"
#include "Car.h"

#include <sstream>

Wheel::Wheel(int angle, const std::function<void(bool)> &onFullTurn)
    : _angle(angle), onFullTurnCb(onFullTurn) {

}

void Wheel::turn(int angle) {
  _angle += angle;

  constexpr auto fullRotation = 360;
  if (fullRotation == _angle) {
    onFullTurnCb(true);
  }
}

std::string Wheel::toString() const {
  std::ostringstream stream;
  stream << "Wheel angle: " << _angle;
  return stream.str();
}
