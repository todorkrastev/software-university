#ifndef AUTOMATICCAR_H_
#define AUTOMATICCAR_H_

#include "Car.h"

class AutomaticCar : public Car {
public:
  AutomaticCar(int maxSpeed, int fuel);

  void increaseSpeed(int speedIncrease, int fuelConsumtion) final;
  void decreaseSpeed(int speedDecrease) final;
};

#endif /* AUTOMATICCAR_H_ */
