#include <iostream>
#include <map>
#include <string>
#include <sstream>


int main() {

	std::map<double, int> numbers;

	std::string input;
	std::getline(std::cin, input);
	std::istringstream strStream(input);

	std::string currNumber;

	while (strStream >> currNumber) {

		if (numbers.find(std::stod(currNumber)) == numbers.end()) {
			numbers[std::stod(currNumber)] = 1;
		} else {
			numbers[std::stod(currNumber)] += 1;
		}
	}

	std::map<double, int>::iterator itr;

	for (itr = numbers.begin(); itr != numbers.end(); itr++) {
		std::cout << itr->first << " -> " << itr->second << std::endl;
	}

	return 0;
}