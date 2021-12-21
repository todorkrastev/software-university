#include <iostream>
using namespace std;

int main() {

	string shape;
	cin >> shape;

	double area = 0;
	if (shape == "square") {
		double side;
		cin >> side;
		area = side * side;
	} else if (shape == "rectangle") {
		double side1, side2;
		cin >> side1 >> side2;
		area = side1 * side2;
	} else if (shape == "circle") {
		double pi = 3.14159265359;
		double r;
		cin >> r;
		area = r * r * pi;
	} else if (shape == "triangle") {
		double side, height;
		cin >> side >> height;
		area = side * height / 2;
	}

	cout.setf(ios::fixed);
	cout.precision(3);

	cout << area << endl;

	return 0;
}
