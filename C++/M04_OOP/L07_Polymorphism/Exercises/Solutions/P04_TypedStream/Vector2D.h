#ifndef VECTOR_2D_H
#define VECTOR_2D_H

#include <cmath>
#include <string>
#include <sstream>

class Vector2D {
	double x, y;
public:
	Vector2D() : x(0), y(0) {}
	Vector2D(double x, double y) : x(x), y(y) {}

	double getLength() const {
		return sqrt(getLengthSq());
	}

	double getLengthSq() const {
		return (this->x * this->x) + (this->y * this->y);
	}

	Vector2D operator*(const double& factor) const {
		Vector2D result = *this;
		result *= factor;
		return result;
	}

	Vector2D& operator*=(const double& factor) {
		this->x *= factor;
		this->y *= factor;
		return *this;
	}
	
	Vector2D operator/(const double& factor) {
		Vector2D result = *this;
		result /= factor;
		return result;
	}

	Vector2D& operator/=(const double& factor) {
		this->x /= factor;
		this->y /= factor;
		return *this;
	}

	Vector2D operator-(const Vector2D& other) const {
		Vector2D result = *this;
		result -= other;
		return result;
	}

	Vector2D& operator-=(const Vector2D& other) {
		this->x -= other.x;
		this->y -= other.y;
		return *this;
	}

	Vector2D operator+(const Vector2D& other) const {
		Vector2D result = *this;
		result += other;
		return result;
	}

	Vector2D& operator+=(const Vector2D& other) {
		this->x += other.x;
		this->y += other.y;
		return *this;
	}

	operator std::string() const {
		std::ostringstream s;
		s << "(" << this->x << ", " << this->y << ")";
		return s.str();
	}
};

#endif // !VECTOR_H

