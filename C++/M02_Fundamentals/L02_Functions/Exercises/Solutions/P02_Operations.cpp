#include <iostream>

double add(double x, double y) {
	return x + y;
}

double sub(double x, double y) {
	return x - y;
}

double mul(double x, double y) {
	return x * y;
}

double div(double x, double y) {
	return x / y;
}


int main() {

	double x, y;
	char c;

	std::cin >> x >> y;
	std::cin >> c;

	double res = 0.0;

	switch (c) {
		case '+': res = add(x, y);
			break;
		case '-': res = sub(x, y);
			break;
		case '*': res = mul(x, y);
			break;
		case '/':
			if (y == 0) {
				std::cout << "Can't divide by zero." << std::endl;
				
				return 0;
			} else {
				res = div(x, y);
			}

			break;
	}

	std::cout << res << std::endl;

	return 0;
}
