#include <iostream>
#include <cmath>


int main() {

	int number = 0;

	while (true) {
		char c;

		std::cin >> c;

		if (c == '.') {
			break;
		}

		if (c >= '0' && c <= '9') {
			int value = (c - '0');

			number *= 10;
			number += value;
		}
	}

	std::cout << sqrt(number) << std::endl;


	return 0;
}
