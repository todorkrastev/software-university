#include <iostream>
#include <string>

int main() {
	int number = 0;
	std::cin >> number;

	for (int i = 1; i <= number; i++) {
		std::cout << i << " ";
	}

	return 0;
}