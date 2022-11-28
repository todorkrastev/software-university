#include "AutomaticCar.h"

AutomaticCar::AutomaticCar(int maxSpeed, int fuel) : Car(maxSpeed, fuel) { }

void AutomaticCar::increaseSpeed(int speedIncrease, int fuelConsumtion) {
  Car::increaseSpeed(speedIncrease, fuelConsumtion);
}

void AutomaticCar::decreaseSpeed(int speedDecrease) {
  Car::decreaseSpeed(2 * speedDecrease);
}
