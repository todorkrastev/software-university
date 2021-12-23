#include <iostream>
#include <cmath>
#include <algorithm>

using namespace std;

int main() {

	int n;
	cin >> n;

	int even = 0;
	int odd = 0;
	for (int i = 0; i < n; i++) {
		int input;
		cin >> input;
		if (i % 2 == 0) {
			even += input;
		} else {
			odd += input;
		}
	}

	if (even == odd) {
		cout << "Yes" << endl;
		cout << "Sum = " << even << endl;
	} else {
		cout << "No" << endl;
		cout << "Diff = " << abs(even - odd) << endl;
	}

	return 0;
}
