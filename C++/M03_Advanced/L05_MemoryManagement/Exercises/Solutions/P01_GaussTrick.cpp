#include <iostream>
#include <sstream>
#include <vector>

void print(const std::vector<int>& vect, const std::string& message) {
	std::cout << message;

	for (std::vector<int>::const_iterator it = vect.begin(); it != vect.end(); it++) {
		std::cout << *it << " ";
	}
}


int main() {

	std::string buf;
	std::getline(std::cin, buf);

	std::istringstream iStr(buf);

	std::vector<int> numbers;
	int digit;

	while (iStr >> digit) {
		numbers.push_back(digit);
	}

	for (size_t i = 0; i < numbers.size() / 2; i++) {
		std::cout << numbers[i] + numbers[numbers.size() - 1 - i] << " ";
	}

	if (numbers.size() % 2) {
		std::cout << numbers[numbers.size() / 2];
	}

	std::cout << std::endl;

	return 0;
}