#include <iostream>
#include <algorithm>

int main() {
	int n = 0, input = 0;
	std::cin >> n;

	int minNum = INT16_MAX;
	int maxNum = INT16_MIN;

	for (int i = 0; i < n; i++) {
		std::cin >> input;

		minNum = std::min(minNum, input);
		maxNum = std::max(maxNum, input);
	}

	std::cout << minNum << " " << maxNum << std::endl;

	return 0;
}