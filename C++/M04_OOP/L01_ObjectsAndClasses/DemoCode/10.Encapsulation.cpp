#include <iostream>
#include <cmath>
using namespace std;

const double PI = 3.141592653589793;

class Circle {
private:
    double radius;
    double area;
public:
    double getRadius() {
        return this->radius;
    }

    double getArea() {
        return this->area;
    }

    void setRadius(double radius) {
        this->radius = radius;
        this->area = radius * radius * PI;
    }

    Circle(double radius) :
        radius(radius),
        area(radius * radius * PI) {}
};

int main() {
    Circle c(10);

    cout << c.getArea() << endl;

    c.setRadius(20);

    cout << c.getArea() << endl;

    return 0;
}
