#include <iostream>
#include <algorithm>
using namespace std;

int main() {

	int n;
	cin >> n;
	int maxNum = INT16_MIN;
	int input;
	for (int i = 0; i < n; i++) {
		cin >> input;
		maxNum = max(maxNum, input);
	}

	cout << maxNum << endl;

	return 0;
}
