#ifndef MANUALCAR_H_
#define MANUALCAR_H_

#include "Car.h"

#include <vector>

class ManualCar : public Car {
public:
  ManualCar(const std::vector<int>& shiftSpeeds, int maxSpeed, int fuel);

  void increaseSpeed(int speedIncrease, int fuelConsumtion) final;
  void decreaseSpeed(int speedDecrease) final;

private:
  size_t findShiftIdx() const;

  std::vector<int> _shiftSpeeds;
  size_t _currShiftIdx { 0 };
};

#endif /* MANUALCAR_H_ */
