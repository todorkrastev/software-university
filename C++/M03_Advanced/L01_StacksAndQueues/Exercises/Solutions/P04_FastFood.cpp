#include <iostream>
#include <string>
#include <sstream>
#include <queue>
#include <algorithm>


void printMaxNum(std::queue<int>orders) {
	int maxNum = INT16_MIN;

	while (!orders.empty()) {
		maxNum = std::max(maxNum, orders.front());

		orders.pop();
	}

	std::cout << maxNum << std::endl;
}


void printLeftOrders(std::queue<int>orders) {
	std::cout << "Orders left: ";

	while (!orders.empty()) {

		orders.size() == 1 ?
			std::cout << orders.front() << std::endl :
			std::cout << orders.front() << " ";

		orders.pop();
	}
}

int main() {

	int foodQuantity;
	std::cin >> foodQuantity;
	std::cin.ignore();

	std::string input;
	getline(std::cin, input);
	std::istringstream streamLine(input);

	std::queue<int> orders;

	std::string currNum;

	while (streamLine >> currNum) {
		orders.push(std::stoi(currNum));
	}

	printMaxNum(orders);

	while (!orders.empty()) {
		if (orders.front() <= foodQuantity) {
			foodQuantity -= orders.front();
			orders.pop();
		} else {
			printLeftOrders(orders);
			
			return 0;
		}
	}

	if (orders.empty()) {
		std::cout << "Orders complete" << std::endl;
	}

	return 0;
}