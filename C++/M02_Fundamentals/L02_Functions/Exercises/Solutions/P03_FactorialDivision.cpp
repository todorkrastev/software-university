#include <iostream>

double factoriel(double x) {

	double result = 1;

	for (; x >= 2; x--) {
		result *= x;
	}

	return result;
}

int main() {

	double x, y;

	std::cin >> x >> y;

	x = factoriel(x);
	y = factoriel(y);

	std::cout.setf(std::ios::fixed);
	std::cout.precision(2);

	std::cout << x / y << std::endl;
}
