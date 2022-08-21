#include <cmath>
#include <iomanip>
#include <iostream>
#include <sstream>
#include <string>

class Point {
private:
	int x, y;

public:
	Point() : x(0), y(0) {}

	Point(int x_, int y_) : x(x_), y(y_) {}

	Point(std::istream& istr);

	int getX() { return x; }
	int getY() { return y; }

	double euclidianDistance(const Point& p2);
};

Point::Point(std::istream& istr) {
	istr >> x >> y;
}

double Point::euclidianDistance(const Point& p2) {
	return sqrt(
		pow(x - p2.x, 2) +
		pow(y - p2.y, 2)
	);
}

int main() {

	Point p1(std::cin), p2(std::cin);

	std::cout << std::setprecision(3) << std::fixed << p1.euclidianDistance(p2) << std::endl;

	return 0;
}