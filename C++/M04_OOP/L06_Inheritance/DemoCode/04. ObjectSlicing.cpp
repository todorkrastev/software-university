#include <iostream>
#include <string>
#include <sstream>

class Vehicle {
protected:
  double speed;

  Vehicle(double speed)
      : speed(speed) {
  }

public:
  std::string toString() const {
    std::ostringstream stream;
    stream << "speed: " << this->speed;
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
    stream << Vehicle::toString() << " altitude: " << this->altitude
           << " heading: " << this->heading;
    return stream.str();
  }
};

int main() {
  Vehicle v = Airplane(250, 10000, 0);

  std::cout << v.toString() << std::endl;

  return 0;
}
