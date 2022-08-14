#include <iostream>
#include <string>
#include <sstream>

class Vehicle {
protected:
	double speed;

	Vehicle(double speed) : speed(speed) {}
public:
	virtual std::string toString() const {
		std::ostringstream stream;
		stream << "speed: " << this->speed;
		return stream.str();
	}

	virtual void stop() {
		this->speed = 0;
	}
};

class Car : public Vehicle {
	bool parkingBrakeOn;
public:
	Car(double speed, bool parkingBrakeOn)
		: Vehicle(speed)
		, parkingBrakeOn(parkingBrakeOn) {}

	std::string toString() const override {
		std::ostringstream stream;
		stream << Vehicle::toString() << " parking brake: " << (this->parkingBrakeOn ? "yes" : "no");
		return stream.str();
	}

	virtual void stop() override {
		Vehicle::stop();
		this->parkingBrakeOn = true;
	}
};

class Airplane : public Vehicle {
	double altitude;
	double heading;
public:
	Airplane(double speed, double altitude, double heading)
		: Vehicle(speed), altitude(altitude), heading(heading) {}

	virtual std::string toString() const override {
		std::ostringstream stream;
		stream << Vehicle::toString() << " altitude: " << this->altitude << " heading: " << this->heading;
		return stream.str();
	}

	virtual void stop() override {
		Vehicle::stop();
		this->altitude = 0;
	}
};

class StaticPlaygroundTrain : public Vehicle {
public:
	StaticPlaygroundTrain() : Vehicle(0) {}

	virtual std::string toString() const override {
		return "cho-choooo!";
	}
};

int main() {
	Airplane plane(510, 2400, 90);

	Vehicle* v = &plane;
	std::cout << v->toString() << std::endl; // calls Airplane::toString() due to override
	v->stop(); // calls Airplane::stop() due to override
	std::cout << v->toString() << std::endl;

	Car car(50, false);
	v = &car;
	std::cout << v->toString() << std::endl; // calls Car::toString() due to override
	v->stop(); // calls Car::stop() due to override
	std::cout << v->toString() << std::endl;

	StaticPlaygroundTrain train;
	v = &train;
	std::cout << v->toString() << std::endl; // calls StaticPlaygroundTrain::toString() due to override
	v->stop(); // calls Vehicle::stop() because there is no override for stop() in StaticPlaygroundTrain
	std::cout << v->toString() << std::endl;

	return 0;
}