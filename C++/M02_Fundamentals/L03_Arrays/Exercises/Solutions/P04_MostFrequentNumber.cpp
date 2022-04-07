#include <iostream>

const unsigned maxSize = 200;

bool getArray(int arr[], unsigned& arrSize) {

	std::cin >> arrSize;

	if (arrSize > maxSize) {
		return false;
	}

	for (int i = 0; i < arrSize; i++) {
		std::cin >> arr[i];
	}

	return true;
}

int main() {

	unsigned arrSize;
	int arr[maxSize];

	getArray(arr, arrSize);

	unsigned counts[10] = {};

	for (int i = 0; i < arrSize; i++) {
		counts[arr[i]]++;
	}

	unsigned maxCount = 0;

	for (int i = 0; i < 10; i++) {
		if (counts[i] > maxCount) {
			maxCount = counts[i];
		}
	}

	for (int i = 0; i < 10; i++) {
		if (counts[i] == maxCount) {
			std::cout << i << " ";
		}
	}

	std::cout << std::endl;

	return 0;
}
