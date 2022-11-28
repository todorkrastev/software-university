#ifndef CPP_ADVANCED_CAR_H
#define CPP_ADVANCED_CAR_H

#include <cstddef>

class Car {
public:
  Car(int maxSpeed, int fuel);

  virtual ~Car() = default;

  int getTotalDistance() const;

  int getSpeed() const;

  int getFuel() const;

  bool hasFuel() const;

  void advance();

  virtual void increaseSpeed(int speedIncrease, int fuelConsumption);

  virtual void decreaseSpeed(int speedDecrease);

private:
  const int _maxSpeed;
  int _totalDistance{0};
  int _speed{0};
  int _fuel;
};


#endif //CPP_ADVANCED_CAR_H
