#include <iostream>
#include <string>
#include <sstream>
#include <stack>


int main() {

	std::string input;
	getline(std::cin, input);
	std::istringstream lineStream(input);

	std::string currItem;

	std::stack<int> stockroom;

	while (lineStream >> currItem) {
		stockroom.push(std::stoi(currItem));
	}

	int shelfCapacity;
	std::cin >> shelfCapacity;

	if (stockroom.empty()) {
		std::cout << 0 << std::endl;

		return 0;
	}

	int counter = 0;
	int sumOfClothes = 0;

	while (!stockroom.empty()) {
		if (sumOfClothes + stockroom.top() <= shelfCapacity) {
			sumOfClothes += stockroom.top();
			stockroom.pop();
		} else {
			sumOfClothes = 0;
			counter++;
		}
	}

	counter++;

	std::cout << counter << std::endl;

	return 0;
}