#include <iostream>
#include <string>


void printClosestPointToCenter(double x1, double y1, double x2, double y2) {

	double d1, d2;

	d1 = x1 * x1 + y1 * y1;
	d2 = x2 * x2 + y2 * y2;

	d1 <= d2 ?
		std::cout << "(" << x1 << ", " << y1 << ")" << std::endl :
		std::cout << "(" << x2 << ", " << y2 << ")" << std::endl;
}


int main() {

	double x1, y1, x2, y2;
	std::cin >> x1 >> y1 >> x2 >> y2;


	printClosestPointToCenter(x1, y1, x2, y2);

	return 0;
}