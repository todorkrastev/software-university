#include <iostream>
#include <climits>
#include <algorithm>
using namespace std;

int main() {

	int maxNum = INT16_MIN;
	int minNum = INT16_MAX;

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int input;
		cin >> input;

		maxNum = max(maxNum, input);
		minNum = min(minNum, input);
	}

	cout << "Max number: " << maxNum << endl;
	cout << "Min number: " << minNum << endl;

	return 0;
}
