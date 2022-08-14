#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <memory>

class Vehicle {
protected:
  double speed;

public:
  Vehicle(double speed)
      : speed(speed) {
  }

  virtual ~Vehicle() {
  }

  virtual std::string toString() const {
    std::ostringstream stream;
    stream << "speed: " << this->speed;
    return stream.str();
  }

  virtual void stop() {
    this->speed = 0;
  }
};

class Car: public Vehicle {
  bool parkingBrakeOn;
public:
  Car(double speed, bool parkingBrakeOn)
      : Vehicle(speed), parkingBrakeOn(parkingBrakeOn) {
  }

  std::string toString() const override {
    std::ostringstream stream;
    stream << Vehicle::toString() << " parking brake: "
           << (this->parkingBrakeOn ? "yes" : "no");
    return stream.str();
  }

  virtual void stop() override {
    Vehicle::stop();
    this->parkingBrakeOn = true;
  }
};

class Airplane: public Vehicle {
  double altitude;
  double heading;
public:
  Airplane(double speed, double altitude, double heading)
      : Vehicle(speed), altitude(altitude), heading(heading) {
  }

  virtual std::string toString() const override {
    std::ostringstream stream;
    stream << Vehicle::toString() << " altitude: " << this->altitude
           << " heading: " << this->heading;
    return stream.str();
  }

  virtual void stop() override {
    Vehicle::stop();
    this->altitude = 0;
  }
};

class StaticPlaygroundTrain: public Vehicle {
public:
  StaticPlaygroundTrain()
      : Vehicle(0) {
  }

  virtual std::string toString() const override {
    return "cho-choooo!";
  }
};

int main() {
  std::vector<std::unique_ptr<Vehicle>> vehicles;
  vehicles.push_back(std::unique_ptr<Vehicle>(new Airplane(510, 2400, 90)));
  vehicles.push_back(std::unique_ptr<Vehicle>(new Car(50, false)));
  vehicles.push_back(std::unique_ptr<Vehicle>(new StaticPlaygroundTrain()));

  for (const auto &vehiclePtr : vehicles) {
    std::cout << vehiclePtr->toString() << std::endl;
    vehiclePtr->stop();
    std::cout << vehiclePtr->toString() << std::endl;
  }

  //notice there is no delete - those are smart pointers
//	for (auto vehiclePtr : vehicles) {
//		delete vehiclePtr;
//	}

  return 0;
}
