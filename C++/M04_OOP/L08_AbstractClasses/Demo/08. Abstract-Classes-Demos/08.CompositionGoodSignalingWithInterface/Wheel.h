#ifndef WHEEL_H_
#define WHEEL_H_

#include <string>

class CarInterface;

class Wheel {
public:
  Wheel(int angle, CarInterface* carInterface);

  void turn(int angle);

  std::string toString() const;

private:
  int _angle;
  CarInterface* _carInterface;
};

#endif /* WHEEL_H_ */
