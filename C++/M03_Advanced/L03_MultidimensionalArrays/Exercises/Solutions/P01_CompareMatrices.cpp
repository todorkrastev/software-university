#include <iostream>
#include <sstream>
#include <string>
#include <vector>

void fillMatrix(int input, std::vector<std::pair<int, std::vector<char>>>& matrix) {
	for (size_t i = 0; i < input; i++) {
		std::pair<int, std::vector<char>> row;
		std::vector<char> col;

		std::string input;
		std::getline(std::cin, input);
		std::istringstream iStrStream(input);

		char currSym;

		while (iStrStream >> currSym) {
			col.push_back(currSym);
		}

		row.first = i;
		row.second = col;
		matrix.push_back(row);
	}
}

int main() {

	int input;
	std::cin >> input;

	std::cin.ignore();

	std::vector<std::pair<int, std::vector<char>>> matrix1;

	fillMatrix(input, matrix1);

	std::cin >> input;

	std::cin.ignore();

	std::vector<std::pair<int, std::vector<char>>> matrix2;

	fillMatrix(input, matrix2);

	if (matrix1.size() != matrix2.size()) {
		std::cout << "not equal" << std::endl;

		return 0;
	}

	std::vector<std::pair<int, std::vector<char>>>::iterator it1 = matrix1.begin();
	std::vector<std::pair<int, std::vector<char>>>::iterator it2 = matrix2.begin();

	while (it1 != matrix1.end() || it2 != matrix2.end()) {
		if (it1->second.size() != it2->second.size()) {
			std::cout << "not equal" << std::endl;

			return 0;
		}

		std::vector<char>::iterator innerIt1 = it1->second.begin();
		std::vector<char>::iterator innerIt2 = it2->second.begin();

		while (innerIt1 != it1->second.end() || innerIt2 != it2->second.end()) {

			if (*innerIt1 != *innerIt2) {
				std::cout << "not equal" << std::endl;

				return 0;
			}

			innerIt1++;
			innerIt2++;
		}

		it1++;
		it2++;
	}

	std::cout << "equal" << std::endl;

	return 0;
}

// -----------------------------------------------------------------------------------------------

// Second option

// -----------------------------------------------------------------------------------------------

#include <iostream>
#include <sstream>


void getMatrix(int mat[][10], int& rows, int& cols) {

	std::cin >> rows;
	std::cin.ignore();

	for (size_t currRow = 0; currRow < rows; currRow++) {

		std::string buffer;
		std::getline(std::cin, buffer);

		std::istringstream iStrStream(buffer);

		cols = 0;
		while (iStrStream >> mat[currRow][cols]) {
			cols++;
		}
	}
}

bool compare(const int mat1[][10], int rows1, int cols1,
	const int mat2[][10], int rows2, int cols2) {

	if (rows1 != rows2 || cols1 != cols2) {
		return false;
	}

	for (size_t currRow = 0; currRow < rows1; currRow++) {
		for (size_t currCol = 0; currCol < cols1; currCol++) {
			if (mat1[currRow][currCol] != mat2[currRow][currCol]) {
				return false;
			}
		}
	}

	return true;
}


int main() {

	int rows1, cols1;
	int rows2, cols2;

	const int r = 10;
	const int c = 10;

	int mat1[r][c], mat2[r][c];

	int currRow, currCol;

	getMatrix(mat1, rows1, cols1);
	getMatrix(mat2, rows2, cols2);

	std::cout << (compare(mat1, rows1, cols1, mat2, rows2, cols2) ?
		"equal" :
		"not equal")
		<< std::endl;

	return 0;
}