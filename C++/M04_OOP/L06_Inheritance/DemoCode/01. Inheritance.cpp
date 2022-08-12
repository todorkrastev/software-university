#include <iostream>
#include <string>
#include <sstream>

class Vehicle {
public:
  double speed;
};

class Car: public Vehicle {
  bool parkingBrakeOn;
public:
  Car(double speed, bool parkingBrakeOn)
      : parkingBrakeOn(parkingBrakeOn) {
    this->speed = speed;
  }

  std::string toString() const {
    std::ostringstream stream;
    stream << "speed: " << this->speed << " parking brake: "
           << (this->parkingBrakeOn ? "yes" : "no");
    return stream.str();
  }
};

class Airplane: public Vehicle {
  double altitude;
  double heading;
public:
  Airplane(double speed, double altitude, double heading)
      : altitude(altitude), heading(heading) {
    this->speed = speed;
  }

  std::string toString() const {
    std::ostringstream stream;
    stream << "speed: " << this->speed << " altitude: " << this->altitude
           << " heading: " << this->heading;
    return stream.str();
  }
};

int main() {
  Car car(90, false);
  Airplane airplane(700, 10000, 90);

  std::cout << car.toString() << std::endl;
  std::cout << airplane.toString() << std::endl;

  return 0;
}
