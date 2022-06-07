#include<iostream>

int* findFirstNegativePtr(int numbers[], int length) {
	for (int i = 0; i < length; i++) {
		if (numbers[i] < 0) {
			return &numbers[i];
		}
	}

	return nullptr;
}

int main() {
	using namespace std;

	int numbers[]{ 1, 5, -1, 12 };

	int* negativePtr = findFirstNegativePtr(numbers, 4);
	if (negativePtr != nullptr) {
		cout << *negativePtr << endl;
	}
	else {
		cout << "no negative numbers" << endl;
	}

	return 0;
}
