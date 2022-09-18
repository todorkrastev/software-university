#ifndef SHAPE_H
#define SHAPE_H

#include "Vector2D.h"

class Shape {
protected:
	Vector2D center;
	double area;
public:
	Shape() : center(Vector2D(0, 0)), area(0) {}

	Shape(Vector2D center) : center(center), area(0) {}

	double getArea() const {
		return this->area;
	}

	Vector2D getCenter() const {
		return this->center;
	}

	virtual ~Shape() {}
};

#endif // !SHAPE_H

