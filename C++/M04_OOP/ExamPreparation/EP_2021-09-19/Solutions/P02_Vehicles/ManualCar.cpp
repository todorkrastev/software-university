#include "ManualCar.h"

size_t findShiftIdx(std::vector<int> const& shiftSpeeds, int forSpeed);

ManualCar::ManualCar(std::vector<int> const& shiftSpeeds, int maxSpeed, int fuel)
    : Car(maxSpeed, fuel), _shiftSpeeds(shiftSpeeds) { }

size_t ManualCar::findShiftIdx() const {
  //not used in solution
  size_t shiftIdx = 0;
  while (_shiftSpeeds.at(shiftIdx) < getSpeed() && shiftIdx < _shiftSpeeds.size() - 1) {
    ++shiftIdx;
  }
  return shiftIdx;
}

void ManualCar::increaseSpeed(int speedIncrease, int fuelConsumtion) {
  const int newSpeed = getSpeed() + speedIncrease;
  size_t newShiftIndex = ::findShiftIdx(_shiftSpeeds, newSpeed);
  if (_currShiftIdx < newShiftIndex) {
    fuelConsumtion *= 2;
  }
  _currShiftIdx = newShiftIndex;

  Car::increaseSpeed(speedIncrease, fuelConsumtion);
}

void ManualCar::decreaseSpeed(int speedDecrease) {
  Car::decreaseSpeed(speedDecrease);
}

size_t findShiftIdx(std::vector<int> const& shiftSpeeds, int forSpeed) {
  size_t shiftIdx = 0;
  while (shiftSpeeds.at(shiftIdx) < forSpeed && shiftIdx < shiftSpeeds.size() - 1) {
    ++shiftIdx;
  }
  return shiftIdx;
}
