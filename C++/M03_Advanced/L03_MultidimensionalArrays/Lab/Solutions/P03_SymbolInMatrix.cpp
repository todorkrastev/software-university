#include <iostream>
#include <string>
#include <sstream>


int main() {

	int num;
	std::cin >> num;

	std::cin.ignore();


	const int r = 100;
	const int c = 100;

	int matrix[r][c]{};

	for (size_t row = 0; row < num; row++) {
		std::string input;
		std::cin >> input;
		std::cin.ignore();

		for (size_t col = 0; col < num; col++) {
			int index = col;

			if (index < input.length()) {
				matrix[row][col] = input[index];
			}
		}
	}

	char symbol;
	std::cin >> symbol;

	std::cin.ignore();

	for (size_t row = 0; row < num; row++) {
		for (size_t col = 0; col < num; col++) {
			if (symbol == matrix[row][col]) {
				std::cout << "(" << row << ", " << col << ")" << std::endl;

				return 0;
			}
		}
	}

	std::cout << symbol << " does not occur in the matrix" << std::endl;

	return 0;
}

//Moves
//Up -> [row--] [x]
//Down -> [row++] [x]
//Left -> [x] [col--]
//Right -> [x] [col++]

//Diagonals
//[row++] [col++]
//[row--] [col--]
//[row++] [col--]
//[row--] [col++]