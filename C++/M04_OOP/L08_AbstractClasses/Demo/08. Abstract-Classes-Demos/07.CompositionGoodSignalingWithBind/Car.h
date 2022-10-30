#ifndef CAR_H_
#define CAR_H_

#include "Wheel.h"

class Car {
public:
  Car(int wheelAngle, double speed);

  std::string toString() const;

  void turnWheel(int angle);

  bool hasMadeFullTurn() const;

private:
  void setFullTurn(bool status);

  Wheel _wheel;
  double _speed;
  bool _hasMadeFullTurn = false;
};

#endif /* CAR_H_ */
