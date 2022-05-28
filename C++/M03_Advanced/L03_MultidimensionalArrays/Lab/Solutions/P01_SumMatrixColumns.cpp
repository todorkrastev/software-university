#include <iostream>
#include <string>
#include <sstream>


int main() {

	int rows, cols;
	std::cin >> rows >> cols;

	std::cin.ignore();

	int matrix[100][100]{};

	for (size_t row = 0; row < rows; row++) {
		std::string input;
		std::getline(std::cin, input);
		std::istringstream istrStream(input);

		std::string currNum;
		for (size_t col = 0; col < cols; col++) {
			if (istrStream >> currNum) {
				matrix[row][col] = std::stoi(currNum);
			} else {
				break;
			}
		}
	}

	for (size_t col = 0; col < cols; col++) {
		int sum = 0;
		for (size_t row = 0; row < rows; row++) {
			sum += matrix[row][col];
		}

		std::cout << sum << std::endl;
	}


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
