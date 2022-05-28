#include <algorithm>
#include <iostream>
#include <sstream>
#include <string>


int main() {


	int num;
	std::cin >> num;


	int leftSum = 0;
	int rightSum = 0;

	for (size_t row = 0; row < num; row++) {
		int rows[num];

		for (size_t col = 0; col < num; col++) {
			std::cin >> rows[col];
		}

		leftSum += rows[row];
		rightSum += rows[num - 1 - row];
	}

	std::cout << std::abs(leftSum - rightSum) << std::endl;

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