#include <iostream>
#include <vector>
#include <sstream>


const char new_rust = '?';
const char old_rust = '!';


void printBoard(char board[10][10], int const& rows, int const& cols) {

	for (size_t row = 0; row < rows; row++) {
		for (size_t col = 0; col < cols; col++) {
			std::cout << board[row][col];
		}
		std::cout << std::endl;
	}
}

void mark(char board[10][10], size_t row, size_t col, char m, int const& rows, int const& cols) {
	if (row < rows && col < cols) {
		if (board[row][col] != '#' && board[row][col] != '!') {
			board[row][col] = m;
		}
	}
}

void processBoard(char board[10][10], int const& rows, int const& cols) {

	for (size_t row = 0; row < rows; row++) {
		for (size_t col = 0; col < cols; col++) {
			if (board[row][col] == old_rust) {
				mark(board, row - 1, col, new_rust, rows, cols);
				mark(board, row + 1, col, new_rust, rows, cols);
				mark(board, row, col - 1, new_rust, rows, cols);
				mark(board, row, col + 1, new_rust, rows, cols);
			}
		}
	}

	for (size_t row = 0; row < rows; row++) {
		for (size_t col = 0; col < cols; col++) {
			if (board[row][col] == new_rust) {
				board[row][col] = old_rust;
			}
		}
	}
}

int main() {

	int const rows = 10;
	int const cols = 10;


	char board[rows][cols];

	for (size_t row = 0; row < rows; row++) {
		std::string buff;
		std::getline(std::cin, buff);
		for (size_t col = 0; col < cols; col++) {
			board[row][col] = buff[col];
		}
	}

	size_t ticks;
	std::cin >> ticks;

	for (size_t tick = 0; tick < ticks; tick++) {
		processBoard(board, rows, cols);
	}

	printBoard(board, rows, cols);

	return 0;
}