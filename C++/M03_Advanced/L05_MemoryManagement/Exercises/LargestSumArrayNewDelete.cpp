#include <iostream>

int main() {
	using namespace std;

	int n;
	cin >> n;

	int maxSum = 0;
	int maxSumArrLength = 0;
	int* maxSumArr = nullptr;
	for (int i = 0; i < n; i++) {
		int length;
		cin >> length;

		int sum = 0;
		int* arr = new int[length];
		for (int arrInd = 0; arrInd < length; arrInd++) {
			cin >> arr[arrInd];
			sum += arr[arrInd];
		}

		if (maxSumArr == nullptr || maxSum < sum) {
			maxSum = sum;
			maxSumArr = arr;
			maxSumArrLength = length;
		}
		else {
			delete[] arr;
		}
	}

	for (int i = 0; i < maxSumArrLength; i++) {
		cout << maxSumArr[i] << " ";
	}
	delete[] maxSumArr;
	cout << endl;

	return 0;
}
