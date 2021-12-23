#include <iostream>
#include <algorithm>
using namespace std;

int main() {

	int n;
	cin >> n;

	int leftSide = 0;
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;

		leftSide += num;
	}

	int rightSide = 0;
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;

		rightSide += num;
	}

	if (leftSide == rightSide) {
		cout << "Yes, sum = " << leftSide << endl;
	} else {
		cout << "No, diff = " << abs(rightSide - leftSide) << endl;
	}

	return 0;
}
