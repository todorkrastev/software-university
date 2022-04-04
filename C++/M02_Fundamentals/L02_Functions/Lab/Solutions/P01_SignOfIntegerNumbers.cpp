#include <iostream>
#include <string>

void printSignOfIntegerNumber(int num) {

	std::string output = "";

	if (num > 0) {
		output = "positive.";
	} else if (num == 0) {
		output = "zero.";
	} else {
		output = "negative.";
	}

	std::cout << "The number " << num << " is " << output << std::endl;
}

int main() {

	int input;
	std::cin >> input;

	printSignOfIntegerNumber(input);

	return 0;
}