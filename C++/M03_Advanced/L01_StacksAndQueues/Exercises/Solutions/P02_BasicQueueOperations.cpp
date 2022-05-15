#include <iostream>
#include <string>
#include <sstream>
#include <queue>


int main() {

	int numOfElements, elementsToRemove, elementToFind;
	std::cin >> numOfElements >> elementsToRemove >> elementToFind;

	std::cin.ignore();

	std::string input;
	getline(std::cin, input);
	std::istringstream lineStream(input);

	std::string currElement;
	int counter = 0;

	std::queue<int> nums;

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


	for (size_t i = 0; i < elementsToRemove; i++) {
		nums.pop();

		if (nums.empty()) {
			std::cout << 0 << std::endl;

			return 0;
		}
	}

	int minNum = INT16_MAX;


	while (!nums.empty()) {
		int currNum = nums.front();

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