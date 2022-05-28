#include <iostream>
#include <string>
#include <sstream>

int main() {

	int num;
	std::cin >> num;

	std::cin.ignore();

	int matrix[100][100];


	for (size_t row = 0; row < num; row++) {
		std::string input;
		std::getline(std::cin, input);
		std::istringstream istrStream(input);

		std::string currNum;

		for (size_t col = 0; col < num; col++) {
			if (istrStream >> currNum) {
				matrix[row][col] = std::stoi(currNum);
			} else {
				break;
			}
		}
	}

	int sum = 0;
	for (size_t i = 0; i < num; i++) {
		sum += matrix[i][i];
	}

	std::cout << sum << std::endl;

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