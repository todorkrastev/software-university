#include <iostream>
#include <cstdlib>

#include "Array.h"

int main() {
	std::cin.sync_with_stdio(false);
	std::cout.sync_with_stdio(false);

	int maxSum;
	Array<int> maxArray(0);

	size_t numArrays;
	std::cin >> numArrays;

	for (size_t i = 0; i < numArrays; i++) {
		size_t arrSize;
		std::cin >> arrSize;
		Array<int> a(arrSize);
		int sum = 0;
		for (size_t elementInd = 0; elementInd < arrSize; elementInd++) {
			int value;
			std::cin >> value;
			a[elementInd] = value;
			sum += value;
		}

		if (maxArray.getSize() == 0 || maxSum < sum) {
			maxArray = a;
			maxSum = sum;
		}
	}

	for (auto element : maxArray) {
		std::cout << element << " ";
	}

	return 0;
}