#include <iostream>
#include <string>
#include <sstream>
#include <stack>
#include <algorithm>


int main() {

	int numOfElements, elementsToPop, elementToFind;
	std::cin >> numOfElements >> elementsToPop >> elementToFind;

	std::cin.ignore();

	std::string input;
	std::getline(std::cin, input);
	std::istringstream lineStream(input);

	std::stack<int> nums;

	std::string currElement;
	int counter = 0;

	while (lineStream >> currElement) {
		if (counter == numOfElements) {
			break;
		}

		nums.push(std::stoi(currElement));

		counter++;
	}

	if (nums.empty()) {
		std::cout << 0 << std::endl;

		return 0;
	}

	for (size_t i = 0; i < elementsToPop; i++) {
		nums.pop();

		if (nums.empty()) {
			std::cout << 0 << std::endl;

			return 0;
		}
	}

	int minNum = INT32_MAX;

	while (!nums.empty()) {
		int currNum = nums.top();

		if (currNum == elementToFind) {
			std::cout << "true" << std::endl;

			return 0;
		}

		minNum = std::min(minNum, currNum);

		nums.pop();
	} 

	std::cout << minNum << std::endl;

	return 0;
}
