#include <iostream>
#include <string>
#include <iomanip>

#include "Circle.h"
#include "Rectangle.h"
#include "CoordinateSystemCenter.h"

Vector2D readVector() {
	double x, y;
	std::cin >> x >> y;

	return Vector2D(x, y);
}

int main() {
	char shapeType;
	std::cin >> shapeType;

	std::cout << std::fixed << std::setprecision(2);

	if (shapeType == 'c') {
		double radius;
		std::cin >> radius;
		Circle c(radius, readVector());
		std::cout << "Circle at " << (std::string)c.getCenter() << ", area: " << c.getArea() << std::endl;
	} else if (shapeType == 'r') {
		double width, height;
		std::cin >> width >> height;
		Rectangle r(width, height, readVector());
		std::cout << "Rectangle at " << (std::string)r.getCenter() << ", area: " << r.getArea() << std::endl;
	} else if (shapeType == 'x') {
		CoordinateSystemCenter center;
		std::cout << "Center at " << (std::string)center.getCenter() << ", area: " << center.getArea() << std::endl;
	} else {
		std::cout << "unknown shape type" << std::endl;
	}

	return 0;
}