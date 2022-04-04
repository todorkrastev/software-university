#include <iostream>

void printUpperPart(int num) {

	for (int k = 1; k <= num; k++) {
		for (int m = 1; m <= k; m++) {
			std::cout << m << " ";
		}
		std::cout << std::endl;
	}
}

void printLowerPart(int num) {

	for (int k = num - 1; k >= 1; k--) {
		for (int m = 1; m <= k; m++) {
			std::cout << m << " ";
		}
		std::cout << std::endl;
	}
}


int main() {

	int input;
	std::cin >> input;

	printUpperPart(input);
	printLowerPart(input);

	return 0;
}