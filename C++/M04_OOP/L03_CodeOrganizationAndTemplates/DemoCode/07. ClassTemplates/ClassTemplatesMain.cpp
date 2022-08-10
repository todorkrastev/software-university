#include <iostream>
#include <string>
#include <cmath>

#include "Pair.h"

Pair<double, double> solveQuadraticEquation(double a, double b, double c) {
	double d = b * b - 4 * a * c;
	return Pair<double, double>((-b + sqrt(d)) / (2 * a),
		(-b - sqrt(d)) / (2 * a));
}


int main() {
	using std::cout;
	using std::endl;
	using std::string;

	Pair<string, int> nameAndAge{ "Joro", 26 };
	cout << nameAndAge.first << " " << nameAndAge.second << endl;

	Pair<double, double> roots = solveQuadraticEquation(2, 5, 2);
	cout << "2*x*x + 5*x - 2:" << endl
		<< "x1 = " << roots.first << endl
		<< "x2 = " << roots.second << endl;

	return 0;
}