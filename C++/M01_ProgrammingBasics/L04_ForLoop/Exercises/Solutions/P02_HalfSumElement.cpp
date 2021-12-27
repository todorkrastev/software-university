#include <iostream>
#include <climits>
#include <algorithm>
using namespace std;

int main() {

	int n;
	cin >> n;

	int maxNum = INT16_MIN;

	int sum = 0;
	for (int i = 0; i < n; i++) {
		int input;
		cin >> input;

		sum += input;

		maxNum = max(maxNum, input);
	}

	sum -= maxNum;


	if (sum == maxNum) {
		cout << "Yes" << endl;
		cout << "Sum = " << maxNum;
	} else {
		cout << "No" << endl;
		cout << "Diff = " << abs(sum - maxNum) << endl;
	}

	return 0;
}
