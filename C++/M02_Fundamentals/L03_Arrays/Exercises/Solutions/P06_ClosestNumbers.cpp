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

	unsigned absDiff = 0;

	for (int first = 0; first < arrSize; first++) {
		for (int second = 0; second < arrSize; second++) {

			int currDiff;

			if (arr[first] > arr[second]) {
				currDiff = arr[first] - arr[second];
			} else {
				currDiff = arr[second] - arr[first];
			}

			if (absDiff == 0) {
				absDiff = currDiff;
			} else {
				if (currDiff != 0 && currDiff < absDiff) {
					absDiff = currDiff;
				}
			}
		}
	}

	std::cout << absDiff << std::endl;

	return 0;
}
