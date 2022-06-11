#include <iostream>


int main() {

	int rows, cols;
	std::cin >> rows >> cols;

	int* array;

	array = new int[rows * cols];

	for (size_t count = 0; count < rows * cols; count++) {
		std::cin >> array[count];
	}

	int outRows, outCols;

	std::cin >> outRows >> outCols;

	for (size_t currRow = 0; currRow < outRows; currRow++) {
		for (size_t currCol = 0; currCol < outCols; currCol++) {
			std::cout << array[currRow * cols + currCol] << " ";
		}
		std::cout << std::endl;
	}

	delete[] array;

	return 0;
}

// -----------------------------------------------------------------------------------------------

// Second Option

// -----------------------------------------------------------------------------------------------

#include <iostream>


int main() {

	int rows, cols;
	std::cin >> rows >> cols;

	int** array;

	array = new int* [rows]; // allocate 'rows' (int *) pointers

	for (size_t row = 0; row < rows; row++) {
		array[row] = new int[cols]; // allocate each row
	}

	for (size_t currRow = 0; currRow < rows; currRow++) {
		for (size_t currCol = 0; currCol < cols; currCol++) {
			std::cin >> array[currRow][currCol];
		}
	}



	int outRows, outCols;

	std::cin >> outRows >> outCols;

	for (size_t currRow = 0; currRow < outRows; currRow++) {
		for (size_t currCol = 0; currCol < outCols; currCol++) {
			std::cout << array[currRow][currCol] << " ";
		}
		std::cout << std::endl;
	}

	for (size_t row = 0; row < rows; row++) {
		delete[] array[row]; // deallocate each row
	}
	delete[] array;

	return 0;
}
