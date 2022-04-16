#include <iostream>
#include <vector>

int main() {
	int rows, cols;
	std::cin >> rows >> cols;

	std::vector<std::string> grid(rows);

	for (int row = 0; row < rows; ++row) {
		std::cin >> grid[row];
	}

	int bombPower = 0;

	int turns;
	std::cin >> turns;
	while (turns-- > 0) {
		std::string command;
		std::cin >> command;

		if (command == "power") {
			std::string type;
			std::cin >> type;
			if (type == "up") {
				bombPower++;
				std::cout << "Increased bomb power to " << bombPower << std::endl;
			} else if (type == "down") {
				if (bombPower > 0) {
					bombPower--;
				}
				std::cout << "Decreased bomb power to " << bombPower << std::endl;
			}
		} else if (command == "bomb") {
			int row, col;
			std::cin >> row >> col;

			int points = 0;

			int startRow = std::max(0, row - bombPower);
			int endRow = std::min(rows - 1, row + bombPower);
			for (int r = startRow; r <= endRow; ++r) {
				points += grid[r][col] - '0';
				grid[r][col] = '0';
			}

			int startCol = std::max(0, col - bombPower);
			int endCol = std::min(cols - 1, col + bombPower);
			for (int c = startCol; c <= endCol; ++c) {
				points += grid[row][c] - '0';
				grid[row][c] = '0';
			}

			std::cout << points << " points" << std::endl;
		}
	}

	return 0;
}