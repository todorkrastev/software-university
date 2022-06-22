#include <iostream>
#include <sstream>
#include <string>

void readMatrix(int**& matrix, size_t& rows, size_t& cols) {

	std::cin >> rows;
	std::cin.ignore();

	matrix = new int* [10];

	for (size_t currRow = 0; currRow < rows; currRow++) {

		matrix[currRow] = new int[10];

		std::string strRow;
		std::getline(std::cin, strRow);
		std::istringstream istr(strRow);

		cols = 0;

		while (istr >> matrix[currRow][cols]) {
			cols++;
		}
	}
}

void freeMatrix(int** matrix) {
	for (size_t i = 0; i < 10; i++) {
		delete[] matrix[i];
	}

	delete[] matrix;
}

bool compareMatrices(int** matrix1, size_t mat1rows, size_t mat1cols,
	int** matrix2, size_t mat2rows, size_t mat2cols) {

	if (mat1rows != mat2rows || mat1cols != mat2cols) {
		return false;
	}

	for (size_t currRow = 0; currRow < mat1rows; currRow++) {
		for (size_t currCol = 0; currCol < mat1cols; currCol++) {
			if (matrix1[currRow][currCol] != matrix2[currRow][currCol]) {
				return false;
			}
		}
	}

	return true;
}

int main() {

	size_t mat1rows, mat1cols;
	int** matrix1;
	readMatrix(matrix1, mat1rows, mat1cols);

	size_t mat2rows, mat2cols;
	int** matrix2;
	readMatrix(matrix2, mat2rows, mat2cols);

	std::cout << (compareMatrices(matrix1, mat1rows, mat1cols, matrix2, mat2rows, mat2cols) ?
		"equal" :
		"not equal")
		<< std::endl;

	freeMatrix(matrix1);
	freeMatrix(matrix2);

	return 0;
}
