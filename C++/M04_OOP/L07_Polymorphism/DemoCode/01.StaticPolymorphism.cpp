#include <iostream>
#include <string>
#include <sstream>

class Vehicle {
protected:
	double speed;

	Vehicle(double speed) : speed(speed) {}

public:
	std::string toString() const {
		std::ostringstream stream;
		stream << "speed: " << this->speed;
		return stream.str();
	}
};

class Airplane : public Vehicle {
	double altitude;
	double heading;
public:
	Airplane(double speed, double altitude, double heading)
		: Vehicle(speed), altitude(altitude), heading(heading) {}

	std::string toString() const {
		std::ostringstream stream;
		stream << Vehicle::toString() << " altitude: " << this->altitude << " heading: " << this->heading;
		return stream.str();
	}
};

int main() {
	Airplane plane(510, 2400, 90);

	Vehicle* v = &plane;
	std::cout << v->toString() << std::endl; // calls Vehicle::toString()

	Airplane* planePtr = static_cast<Airplane*>(v); // converting back from the Vehicle*, to show that there is no slicing
	std::cout << planePtr->toString() << std::endl; // calls Airplane::toString()

	return 0;
}
