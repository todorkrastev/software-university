#ifndef CAR_H_
#define CAR_H_

#include "CarInterface.h"
#include "Wheel.h"

#include <string>

class Car : public CarInterface {
public:
  Car(int wheelAngle, double speed);

  std::string toString() const;

  void turnWheel(int angle);

  bool hasMadeFullTurn() const;

private:
  void setFullTurn(bool status) final;

  Wheel _wheel;
  double _speed;
  bool _hasMadeFullTurn = false;
};

#endif /* CAR_H_ */
