#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

int main() {

	int n, m;
	std::cin >> n >> m;
	std::cin.ignore();

	std::vector<float> firstSetOfNums;
	std::vector<float> secondSetOfNums;

	float input;

	for (size_t i = 0; i < n; i++) {
		std::cin >> input;

		if (std::find(firstSetOfNums.begin(), firstSetOfNums.end(), input) == firstSetOfNums.end()) {
			firstSetOfNums.push_back(input);
		}
	}

	for (size_t i = 0; i < m; i++) {
		std::cin >> input;

		if (std::find(secondSetOfNums.begin(), secondSetOfNums.end(), input) == secondSetOfNums.end()) {
			secondSetOfNums.push_back(input);
		}
	}

	for (size_t i = 0; i < firstSetOfNums.size(); i++) {

		if (std::find(secondSetOfNums.begin(), secondSetOfNums.end(), firstSetOfNums[i]) != secondSetOfNums.end()) {
			std::cout << firstSetOfNums[i] << " ";
		}
	}

	return 0;
}