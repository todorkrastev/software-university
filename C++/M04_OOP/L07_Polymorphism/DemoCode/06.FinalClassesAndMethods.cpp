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

class SportCar final : public Car {
  bool spoilerOn;
public:
  SportCar(double speed, bool parkingBrakeOn, bool spoilerOn)
      : Car(speed, parkingBrakeOn), spoilerOn(spoilerOn) {
  }

  std::string toString() const override {
    std::ostringstream stream;
    stream << Car::toString() << ", spoilerOn: "
           << (this->spoilerOn ? "yes" : "no");
    return stream.str();
  }

  virtual void stop() final {
    Car::stop();
    this->spoilerOn = false;
  }
};

int main() {
  std::vector<std::unique_ptr<Vehicle>> vehicles;
  vehicles.push_back(std::unique_ptr<Vehicle>(new Car(50, false)));
  vehicles.push_back(std::unique_ptr<Vehicle>(new SportCar(70, false, true)));

  for (const auto &vehiclePtr : vehicles) {
    std::cout << vehiclePtr->toString() << std::endl;
    vehiclePtr->stop();
    std::cout << vehiclePtr->toString() << std::endl;
  }

  return 0;
}
