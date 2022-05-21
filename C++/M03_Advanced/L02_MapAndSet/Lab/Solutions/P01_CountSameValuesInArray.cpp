#include <iostream>
#include <algorithm>
#include <string>
#include <sstream>
#include <vector>

int main() {

	std::string input;
	std::getline(std::cin, input);
	std::istringstream streamLine(input);

	std::string currEl;

	std::pair<double, int> counter;
	std::vector<std::pair<double, int>> result;

	while (streamLine >> currEl) {
		double currNum = std::stod(currEl);

		int index = -1;

		for (size_t i = 0; i < result.size(); i++) {
			if (result[i].first == currNum) {
				index = i;
				break;
			} 
		}

		if (index == -1) {
			counter.first = currNum;
			counter.second = 1;
			result.push_back(counter);
		}
		else {
			result[index].second += 1;
		}
	}

	for (size_t i = 0; i < result.size(); i++) {
		std::cout << result[i].first << " - " << result[i].second << " times" << std::endl;
	}

	return 0;
}