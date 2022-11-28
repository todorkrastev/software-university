#include "Car.h"

Car::Car(int const maxSpeed, int fuel)
    : _maxSpeed(maxSpeed), _fuel(fuel) { }

int Car::getTotalDistance() const {
  return _totalDistance;
}

int Car::getSpeed() const {
  return _speed;
}

int Car::getFuel() const {
  return _fuel;
}

bool Car::hasFuel() const {
  return _fuel > 0;
}

void Car::advance() {
  _totalDistance += _speed;
}

void Car::increaseSpeed(int speedIncrease, int fuelConsumption) {
  _fuel -= fuelConsumption;
  if (hasFuel()) {
    _speed += speedIncrease;
    if (_speed > _maxSpeed) {
      _speed = _maxSpeed;
    }
  } else {
    _speed = 0;
    _fuel = 0;
  }
}

void Car::decreaseSpeed(int speedDecrease) {
  _speed -= speedDecrease;
  if (_speed < 0) {
    _speed = 0;
  }
}
