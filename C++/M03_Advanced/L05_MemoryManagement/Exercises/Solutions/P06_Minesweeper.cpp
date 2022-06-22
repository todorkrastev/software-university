#include <iostream>

void printMinefield(size_t rows, size_t cols, const char* field) {

	for (size_t currRow = 0; currRow < rows; currRow++) {
		for (size_t currCol = 0; currCol < cols; currCol++) {
			std::cout << field[currRow * cols + currCol];
		}
		std::cout << std::endl;
	}
}

int hasMine(size_t currRow, size_t currCol, const char* field, size_t rows, size_t cols) {

	if (currRow >= rows || currCol >= cols) {
		return 0;
	}

	return field[currRow * cols + currCol] == '!' ? 1 : 0;
}

char numberOfMines(size_t currRow, size_t currCol, const char* field, size_t rows, size_t cols) {

	char mines = '0' +
		hasMine(currRow - 1, currCol - 1, field, rows, cols) +
		hasMine(currRow - 1, currCol, field, rows, cols) +
		hasMine(currRow - 1, currCol + 1, field, rows, cols) +
		hasMine(currRow, currCol - 1, field, rows, cols) +
		hasMine(currRow, currCol, field, rows, cols) +
		hasMine(currRow, currCol + 1, field, rows, cols) +
		hasMine(currRow + 1, currCol - 1, field, rows, cols) +
		hasMine(currRow + 1, currCol, field, rows, cols) +
		hasMine(currRow + 1, currCol + 1, field, rows, cols);

	return mines;
}

int main() {

	size_t rows, cols;
	std::cin >> rows >> cols;

	char* minefield = new char[rows * cols];

	for (size_t i = 0; i < rows * cols; i++) {
		std::cin >> minefield[i];
	}

	char* digitfield = new char[rows * cols];

	for (size_t currRow = 0; currRow < rows; currRow++) {
		for (size_t currCol = 0; currCol < cols; currCol++) {
			digitfield[currRow * cols + currCol] = numberOfMines(currRow, currCol, minefield, rows, cols);
		}
	}

	printMinefield(rows, cols, digitfield);


	delete[] digitfield;
	delete[] minefield;

	return 0;
}


// -----------------------------------------------------------------------------------------------

// Second Option

// -----------------------------------------------------------------------------------------------


#include <iostream>

void printMinefield(size_t rows, size_t cols, char** field) {

	for (size_t currRow = 0; currRow < rows; currRow++) {
		for (size_t currCol = 0; currCol < cols; currCol++) {
			std::cout << field[currRow][currCol];
		}
		std::cout << std::endl;
	}
}

int hasMine(size_t currRow, size_t currCol, char** field, size_t rows, size_t cols) {

	if (currRow >= rows || currCol >= cols) {
		return 0;
	}

	return field[currRow][currCol] == '!' ? 1 : 0;
}

char numberOfMines(size_t currRow, size_t currCol, char** field, size_t rows, size_t cols) {

	char mines = '0' +
		hasMine(currRow - 1, currCol - 1, field, rows, cols) +
		hasMine(currRow - 1, currCol, field, rows, cols) +
		hasMine(currRow - 1, currCol + 1, field, rows, cols) +
		hasMine(currRow, currCol - 1, field, rows, cols) +
		hasMine(currRow, currCol, field, rows, cols) +
		hasMine(currRow, currCol + 1, field, rows, cols) +
		hasMine(currRow + 1, currCol - 1, field, rows, cols) +
		hasMine(currRow + 1, currCol, field, rows, cols) +
		hasMine(currRow + 1, currCol + 1, field, rows, cols);

	return mines;
}

int main() {

	size_t rows, cols;
	std::cin >> rows >> cols;

	char** minefield = new char* [rows];

	for (size_t currRow = 0; currRow < rows; currRow++) {
		minefield[currRow] = new char[cols];
	}

	for (size_t currRow = 0; currRow < rows; currRow++) {
		for (size_t currCol = 0; currCol < cols; currCol++) {
			std::cin >> minefield[currRow][currCol];
		}
	}

	char** digitfield = new char* [rows];

	for (size_t currRow = 0; currRow < rows; currRow++) {
		digitfield[currRow] = new char[cols];
	}

	for (size_t currRow = 0; currRow < rows; currRow++) {
		for (size_t currCol = 0; currCol < cols; currCol++) {
			digitfield[currRow][currCol] = numberOfMines(currRow, currCol, minefield, rows, cols);
		}
	}

	printMinefield(rows, cols, digitfield);

	for (size_t currRow = 0; currRow < rows; currRow++) {
		delete[] minefield[currRow];
		delete[] digitfield[currRow];
	}

	delete[] digitfield;
	delete[] minefield;

	return 0;
}