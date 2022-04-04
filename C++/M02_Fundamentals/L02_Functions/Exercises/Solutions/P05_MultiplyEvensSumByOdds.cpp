#include <iostream>
#include <string>

void getSumOfOddAndEvenNums(std::string input) {

	double evenSum = 0.0, oddSum = 0.0;

	for (int i = 0; i < (int)input.length(); i++) {

		char currChar = input.at(i);

		if (currChar != '-') {
			int currNum = (int)currChar - '0';

			currNum % 2 == 0 ?
				evenSum += currNum :
				oddSum += currNum;
		}
	}

	std::cout << evenSum * oddSum << std::endl;
}

int main() {

	std::string input;
	std::cin >> input;


	getSumOfOddAndEvenNums(input);
}
