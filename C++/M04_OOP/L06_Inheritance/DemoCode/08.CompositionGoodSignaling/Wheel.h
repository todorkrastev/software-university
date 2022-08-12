#ifndef WHEEL_H_
#define WHEEL_H_

#include <string>
#include <functional>

class Wheel {
public:
  Wheel(int angle, const std::function<void(bool)>& onFullTurn);

  void turn(int angle);

  std::string toString() const;

private:
  int _angle;
  std::function<void(bool)> onFullTurnCb;
};

#endif /* WHEEL_H_ */
