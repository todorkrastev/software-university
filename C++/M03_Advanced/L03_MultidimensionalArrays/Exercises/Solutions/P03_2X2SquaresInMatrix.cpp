#include <iostream>
#include <sstream>
#include <string>
#include <vector>


bool isRightElementEqual(char currSym, std::vector<std::vector<char>>matrix, size_t row, size_t col) {

	col++;

	if (currSym != matrix[row][col]) {
		return false;
	}

	return true;
}


bool isDownElementEqual(char currSym, std::vector<std::vector<char>>matrix, size_t row, size_t col) {

	row++;

	if (currSym != matrix[row][col]) {
		return false;
	}

	return true;
}


bool isDownRightElementEqual(char currSym, std::vector<std::vector<char>>matrix, size_t row, size_t col) {

	row++;
	col++;

	if (currSym != matrix[row][col]) {
		return false;
	}

	return true;
}


bool isIndexInBounds(std::vector<std::vector<char>>matrix, size_t row, size_t col) {

	row++;
	col++;

	if (row < matrix.size() && col < matrix[row].size()) {
		return true;
	}

	return false;
}


int main() {

	int rows, cols;
	std::cin >> rows >> cols;
	std::cin.ignore();

	std::vector<std::vector<char>> matrix;

	for (size_t row = 0; row < rows; row++) {

		std::string input;
		std::getline(std::cin, input);
		std::istringstream iStrStream(input);

		std::vector<char> col;
		char currSym;

		while (iStrStream >> currSym) {
			col.push_back(currSym);
		}

		matrix.push_back(col);

	}


	int counter = 0;

	for (size_t row = 0; row < matrix.size(); row++) {

		for (size_t col = 0; col < matrix[row].size(); col++) {

			char currSym = matrix[row][col];

			if (isIndexInBounds(matrix, row, col)) {

				if (isRightElementEqual(currSym, matrix, row, col) &&
					isDownElementEqual(currSym, matrix, row, col) &&
					isDownRightElementEqual(currSym, matrix, row, col)) {

					counter++;
				}
			}
		}
	}

	std::cout << counter << std::endl;

	return 0;
}

// -----------------------------------------------------------------------------------------------

// Second option

// -----------------------------------------------------------------------------------------------

#include <iostream>
#include <vector>

bool checkTwoByTwoSquare(const std::vector<std::vector<char>> matrix, int row, int col) {

	return matrix[row][col] == matrix[row][col + 1] &&
		matrix[row][col] == matrix[row + 1][col] &&
		matrix[row][col] == matrix[row + 1][col + 1];

}


int main() {

	std::vector<std::vector<char>> matrix;
	int rows, cols;

	std::cin >> rows >> cols;
	matrix.resize(rows);


	for (size_t currRow = 0; currRow < rows; currRow++) {
		matrix[currRow].resize(cols);
		for (size_t currCol = 0; currCol < cols; currCol++) {
			std::cin >> matrix[currRow][currCol];
		}
	}

	int twoByTwoSquares = 0;

	for (size_t currRow = 0; currRow < rows - 1; currRow++) {
		for (size_t currCol = 0; currCol < cols - 1; currCol++) {
			if (checkTwoByTwoSquare(matrix, currRow, currCol)) {
				twoByTwoSquares++;
			}
		}
	}

	std::cout << twoByTwoSquares << std::endl;

	return 0;
}