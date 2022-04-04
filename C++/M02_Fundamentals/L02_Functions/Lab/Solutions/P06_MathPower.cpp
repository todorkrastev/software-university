#include <iostream>
#include<cmath>

int raiseNumberToGivenPower(int number, int power) {

	return pow(number, power);
}

int main() {

	int number, power;
	std::cin >> number >> power;

	
	std::cout << raiseNumberToGivenPower(number, power) << std::endl;

	return 0;
}