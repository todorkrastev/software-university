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

	int arrSum = 0;

	for (int i = 0; i < arrSize; arrSum += arr[i], i++);

	int averageNum = arrSum / arrSize;

	for (int i = 0; i < arrSize; i++) {
		if (arr[i] >= averageNum) {
			std::cout << arr[i] << " ";
		}
	}

	std::cout << std::endl;

	return 0;
}
