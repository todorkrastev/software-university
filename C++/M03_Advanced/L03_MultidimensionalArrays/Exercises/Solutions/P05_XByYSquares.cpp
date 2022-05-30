#include <iostream>
#include <vector>

bool checkForSquare(int squareSize, const std::vector<std::vector<char>> matrix, int row, int col) {

	char currChar = matrix[row][col];

	for (size_t currRow = row; currRow < (row + squareSize); currRow++) {
		for (size_t currCol = col; currCol < (col + squareSize); currCol++) {
			if (currChar != matrix[currRow][currCol]) {
				return false;
			}
		}
	}

	return true;

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

	size_t XByYSquares = 0;
	size_t maxSquareSize = rows > cols ? cols : rows;

	for (size_t squareSize = 2; squareSize < maxSquareSize; squareSize++) {
		for (size_t currRow = 0; currRow < rows - squareSize + 1; currRow++) {
			for (size_t currCol = 0; currCol < cols - squareSize + 1; currCol++) {
				if (checkForSquare(squareSize, matrix, currRow, currCol)) {
					XByYSquares++;
				}
			}
		}
	}


	std::cout << XByYSquares << std::endl;

	return 0;
}