#include <iostream>
#include <string>
#include <sstream>

struct Vehicle {
public:
	double speed;
	Vehicle() : speed(0) {}
};

class Airplane : public Vehicle {
public:
	double speed;
	double altitude;
	double heading;

	Airplane(double speed, double altitude, double heading)
		: speed(speed), altitude(altitude), heading(heading) {}
};

int main() {
	Vehicle v = Airplane(250, 10000, 0);

	std::cout << v.speed << std::endl;

	return 0;
}