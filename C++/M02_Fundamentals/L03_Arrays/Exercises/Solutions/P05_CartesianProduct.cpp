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

	for (int mul1 = 0; mul1 < arrSize; mul1++) {
		for (int mul2 = 0; mul2 < arrSize; mul2++) {
			std::cout << arr[mul1] * arr[mul2] << " ";
		}
	}

	std::cout << std::endl;

	return 0;
}
