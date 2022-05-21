#include <iostream>
#include <map>
#include <algorithm>

int main() {

	int numOfInputs;
	std::cin >> numOfInputs;
	std::map<int, int> nums;

	int currNum;
	int result = 0;

	for (size_t i = 0; i < numOfInputs; i++) {

		std::cin >> currNum;

		if (nums.find(currNum) == nums.end()) {
			nums[currNum] = 1;
		} else {
			nums[currNum] += 1;
		}
	}

	std::map<int, int>::iterator itr;

	for (itr = nums.begin(); itr != nums.end(); itr++) {
		if (itr->second % 2 == 0) {
			std::cout << itr->first << std::endl;
		}
	}

	return 0;
}