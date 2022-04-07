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

	if (getArray(arr, arrSize) == false) {
		return -1;
	}

	int maxLength = 0;
	int longestNumber = 0;

	int currLength = 1;
	int currNumber = arr[0];

	for (int i = 1; i < arrSize; i++) {

		if (arr[i] == currNumber) {
			currLength++;
		} else {
			if (currLength >= maxLength) {
				maxLength = currLength;
				longestNumber = currNumber;
			}

			currLength = 1;
			currNumber = arr[i];
		}
	}

	if (currLength >= maxLength) {
		maxLength = currLength;
		longestNumber = currNumber;
	}

	for (int i = 0; i < maxLength; i++) {
		std::cout << longestNumber << " ";
	}

	std::cout << std::endl;

	return 0;
}
