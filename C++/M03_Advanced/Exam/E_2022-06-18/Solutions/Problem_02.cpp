#include <iostream>
#include <string>

int main() {

	int matrixSize;
	std::cin >> std::ws >> matrixSize;

	std::string matrix[6][6];
	
	int sumOddNums = 0;

	for (size_t currRow = 0; currRow < matrixSize; currRow++) {
		for (size_t currCol = 0; currCol < matrixSize; currCol++) {
			std::string currNum;
			std::cin >> std::ws >> currNum;

			matrix[currRow][currCol] = currNum;
		}
	}

	int currRow = 0;
	int currCol = 0;

	while (true) {
		if (0 <= currCol && currCol < matrixSize && 0 <= currRow && currRow < matrixSize) {
			matrix[currRow][currCol] = "*";
			currRow++;
			currCol++;
		} else {
			break;
		}
	}

	currRow = matrixSize - 1;
	currCol = 0;

	while (true) {
		if (0 <= currCol && currCol < matrixSize && 0 <= currRow && currRow < matrixSize) {
			matrix[currRow][currCol] = "*";
			currRow--;
			currCol++;
		} else {
			break;
		}
	}

	int oddSum = 0;
	
	for (size_t currRow = 0; currRow < matrixSize; currRow++) {
		for (size_t currCol = 0; currCol < matrixSize; currCol++) {
			if (matrix[currRow][currCol] != "*" && std::stoi(matrix[currRow][currCol]) % 2 == 1) {
				oddSum += std::stoi(matrix[currRow][currCol]);
			}
		}
	}

	std::cout << "The sum is: " << oddSum << std::endl;

	return 0;
}