#include <iostream>
#include <string>
#include <sstream>
#include <queue>


int main() {

	std::string input;
	getline(std::cin, input);
	std::istringstream lineStream(input);

	std::string currEl;

	std::queue<std::string> nums;

	while (lineStream >> currEl) {

		if (std::stoi(currEl) % 2 == 0) {
			nums.push(currEl);
		}
	}

	int counter = 0;
	while (!nums.empty()) {
		nums.size() == 1 ?
			std::cout << nums.front() :
			std::cout << nums.front() + ", ";
		nums.pop();
	}

	return 0;
}