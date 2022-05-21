#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <algorithm>


int main() {

	std::string input;
	std::getline(std::cin, input);
	std::istringstream strStream(input);

	std::string currNumber;
	std::vector<double> numbers;

	while (strStream >> currNumber) {

		numbers.push_back(std::stod(currNumber));
	}

	std::sort(numbers.begin(), numbers.end(), std::less<double>());

	std::vector<double>::iterator itr;
	
	for (itr = numbers.begin(); itr != numbers.end(); itr++) {
		if (itr != numbers.begin()) {
			std::cout << " <= ";
		}

		std::cout << *itr;
	}

	return 0;
}