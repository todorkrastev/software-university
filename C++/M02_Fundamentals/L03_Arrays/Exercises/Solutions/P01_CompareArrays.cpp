#include <iostream>

const unsigned maxSize = 200;

bool areEqual(int arr1[], int length1, int arr2[], int length2) {

	if (length1 != length2) {
		return false;
	}

	for (int i = 0; i < length2; i++) {
		if (arr1[i] != arr2[i]) {
			return false;
		}
	}

	return true;
}

bool getArray(int arr[], int & arrSize) {

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

	int arr1size;
	int arr1[maxSize];
	
	if (getArray(arr1, arr1size) == false) {
		return -1;
	}

	int arr2size;
	int arr2[maxSize];

	if (getArray(arr2, arr2size) == false) {
		return -1;
	}

	if (areEqual(arr1, arr1size, arr2, arr2size)) {
		std::cout << "equal" << std::endl;
	} else {
		std::cout << "Not equal" << std::endl;
	}

	return 0;
}
