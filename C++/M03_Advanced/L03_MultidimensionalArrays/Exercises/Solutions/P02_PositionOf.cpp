#include <iostream>
#include <sstream>
#include <string>
#include <vector>


int main() {

	int rows, cols;
	std::cin >> rows >> cols;
	std::cin.ignore();

	std::vector<std::vector<int>> matrix;

	for (size_t row = 0; row < rows; row++) {

		std::string input;
		std::getline(std::cin, input);
		std::istringstream iStrStream(input);

		std::vector<int> col;
		std::string currSym;

		while (iStrStream >> currSym) {
			col.push_back(std::stoi(currSym));
		}

		matrix.push_back(col);
	}

	int numToFind;
	std::cin >> numToFind;
	std::cin.ignore();

	bool isFound = false;

	for (size_t row = 0; row < matrix.size(); row++) {
		for (size_t col = 0; col < matrix[row].size(); col++) {

			if (numToFind == matrix[row][col]) {
				std::cout << row << " " << col << std::endl;

				isFound = true;
			}
		}
	}

	if (!isFound) {
		std::cout << "not found" << std::endl;
	}

	std::cout << std::endl;

	return 0;
}

// -----------------------------------------------------------------------------------------------

// Second option

// -----------------------------------------------------------------------------------------------


#include <iostream>
#include <vector>

int main() {

	std::vector<int> matrix;
	int rows, cols;
	int number;

	std::cin >> rows >> cols;
	matrix.resize(rows * cols);

	
	for (size_t curr = 0; curr < rows*cols; curr++) {
		std::cin >> matrix[curr];
	}

	std::cin >> number;

	bool found = false;

	for (size_t curr = 0; curr < rows * cols; curr++) {
		if (matrix[curr] == number) {
			std::cout << curr / cols << " " << curr % cols << std::endl;

			found = true;
		}
	}

	if (!found) {
		std::cout << "not found" << std::endl;
	}

	return 0;
}