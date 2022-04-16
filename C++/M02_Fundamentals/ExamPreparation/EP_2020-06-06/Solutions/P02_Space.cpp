#include <iostream>
#include <vector>
#include <iterator>

int main() {
	size_t size;
	std::cin >> size;

	std::vector<std::vector<char>> space{ size, std::vector<char>(size) };
	size_t row, col;
	for (size_t r = 0; r < size; ++r) {
		for (size_t c = 0; c < size; ++c) {
			std::cin >> space[r][c];

			if (space[r][c] == 'K') {
				row = r;
				col = c;
			}
		}
	}

	int spaceDust;
	std::cin >> spaceDust;

	char command;
	while (std::cin >> command && command != 'S') {
		space[row][col] = '-';
		switch (command) {
		case 'L':
			--col;
			break;
		case 'R':
			++col;
			break;
		case 'D':
			++row;
			break;
		case 'U':
			--row;
			break;
		}

		if (row < 0 || row >= size || col < 0 || col >= size) {
			spaceDust /= 4;
			break;
		}

		switch (space[row][col]) {
		case 'V':
		case 'S':
		case 'U':
		case 'N':
			spaceDust += space[row][col];
			break;
		case '-':
			break;
		default:
			spaceDust /= 2;
			break;
		}

		space[row][col] = 'K';
	}

	std::cout << "Space Dust Collected: " << spaceDust << std::endl;

	for (const auto& r : space) {
		std::copy(r.begin(), r.end(), std::ostream_iterator<char>(std::cout, " "));
		std::cout << std::endl;
	}

	return 0;
}