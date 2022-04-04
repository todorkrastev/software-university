#include <iostream>

double getRecatngleArea(double a, double b) {

	return a * b;
}

int main() {

	int a, b;
	std::cin >> a >> b;

	std::cout << getRecatngleArea(a, b) << std::endl;

	return 0;
}