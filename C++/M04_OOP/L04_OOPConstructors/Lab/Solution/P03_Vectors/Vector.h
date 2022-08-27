#ifndef VECTOR_H
#define VECTOR_H

#include <istream>
#include <ostream>
#include <cmath>

class Vector {
	double x;
	double y;
public:
	Vector() : x(0), y(0) {}
	Vector(double x, double y) : x(x), y(y) {}

	double getLength() const {
		return sqrt(getLengthSq());
	}

	double getLengthSq() const {
		return this->x * this->x + this->y * this->y;
	}

	double getX() const {
		return this->x;
	}

	double getY() const {
		return this->y;
	}
};

std::ostream& operator<<(std::ostream& out, const Vector& v) {
	return out << v.getX() << " " << v.getY();
}

std::istream& operator>>(std::istream& in, Vector& v) {
	double x, y;
	in >> x >> y;

	v = Vector(x, y);

	return in;
}

#endif // !VECTOR_H

