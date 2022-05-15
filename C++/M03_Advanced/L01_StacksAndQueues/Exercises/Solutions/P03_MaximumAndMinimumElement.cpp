#include <iostream>
#include <stack>
#include <algorithm>


void printMaxNum(std::stack<int>nums) {
	int maxNum = INT16_MIN;

	while (!nums.empty()) {
		maxNum = std::max(maxNum, nums.top());

		nums.pop();
	}

	std::cout << maxNum << std::endl;
}

void printMinNum(std::stack<int>nums)
{
	int minNum = INT16_MAX;

	while (!nums.empty()) {
		minNum = std::min(minNum, nums.top());

		nums.pop();
	}

	std::cout << minNum << std::endl;
}

int main() {

	int num;
	std::cin >> num;

	std::stack<int> nums;

	int command;

	int numToPush;

	for (size_t i = 0; i < num; i++) {

		std::cin >> command;

		switch (command) {
		case 1:
			std::cin >> numToPush;

			nums.push(numToPush);
			break;
		case 2:
			if (!nums.empty()) {
				nums.pop();
			}
			break;
		case 3:
			if (nums.empty()) {
				break;
			}

			printMaxNum(nums);
			break;
		case 4:
			if (nums.empty()) {
				break;
			}

			printMinNum(nums);
			break;
		default:
			break;
		}
	}

	while (!nums.empty()) {

		nums.size() == 1 ?
			std::cout << nums.top() << std::endl :
			std::cout << nums.top() << ", ";

		nums.pop();
	}


	return 0;
}