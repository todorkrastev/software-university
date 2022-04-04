#include <iostream>
#include <algorithm>
#include <string>

int getSmallestNumber(int num1, int num2, int num3) {

	return std::min({ num1, num2, num3 });
}

int main() {

	int num1, num2, num3;
	std::cin >> num1 >> num2 >> num3;


	std::cout << getSmallestNumber(num1, num2, num3) << std::endl;

	return 0;
}