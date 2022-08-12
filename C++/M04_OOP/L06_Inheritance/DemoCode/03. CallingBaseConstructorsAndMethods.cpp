#include <iostream>
#include <string>
#include <sstream>

class Vehicle {
protected:
  double speed;

  Vehicle(double speed)
      : speed(speed) {
  }

  std::string toString() const {
    std::ostringstream stream;
    stream << "speed: " << this->speed;
    return stream.str();
  }
};

class Car: public Vehicle {
  bool parkingBrakeOn;
public:
  Car(double speed, bool parkingBrakeOn)
      : Vehicle(speed), parkingBrakeOn(parkingBrakeOn) {
  }

  std::string toString() const {
    std::ostringstream stream;
    stream << Vehicle::toString() << " parking brake: "
           << (this->parkingBrakeOn ? "yes" : "no");
    return stream.str();
  }
};

class Airplane: public Vehicle {
  double altitude;
  double heading;
public:
  Airplane(double speed, double altitude, double heading)
      : Vehicle(speed), altitude(altitude), heading(heading) {
  }

  std::string toString() const {
    std::ostringstream stream;
    stream << Vehicle::toString() << this->speed << " altitude: "
           << this->altitude << " heading: " << this->heading;
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
