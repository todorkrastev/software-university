#include <iostream>
#include <string>
#include <vector>


bool isIndexInBounds(std::string input, int index) {

	index++;

	if (index < input.length()) {
		return true;
	}

	return false;
}


int main() {

	int rows, cols;
	std::cin >> rows >> cols;
	std::cin.ignore();


	std::vector<std::string> strings;
	std::string input;
	std::getline(std::cin, input);

	int index = 0;

	for (size_t row = 0; row < rows; row++) {

		std::string currLine;


		for (size_t col = 0; col < cols; col++) {

			currLine += input[index];

			isIndexInBounds(input, index) ?
				index++ :
				index = 0;
		}

		if (row % 2 == 0) {
			strings.push_back(currLine);
		}
		else {
			std::string reverseCurrLine = std::string(currLine.rbegin(), currLine.rend());

			strings.push_back(reverseCurrLine);
		}
	}

	for (size_t line = 0; line < strings.size(); line++) {
		std::cout << strings[line] << std::endl;
	}

	return 0;
}