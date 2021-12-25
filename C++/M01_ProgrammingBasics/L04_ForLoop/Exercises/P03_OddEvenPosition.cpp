#include <iostream>
#include <climits>
#include <cmath>
using namespace std;

int main() {

	int n;
	cin >> n;

	double oddSum = 0;
	double oddMin = LONG_MAX;
	double oddMax = LONG_MIN;
	double evenSum = 0;
	double evenMin = LONG_MAX;
	double evenMax = LONG_MIN;

	for (int i = 0; i < n; i++) {
		int input;
		cin >> input;

		if (input % 2 == 0) {
			evenSum += input;
			evenMin = fmin(evenMin, input);
			evenMax = fmax(evenMax, input);
		} else {
			oddSum += input;
			oddMin = fmin(oddMin, input);
			oddMax = fmax(oddMax, input);
		}
	}

	cout.setf(ios::fixed);
	cout.precision(2);

	cout << "OddSum=" << oddSum << "," << endl;
	if (oddSum == 0) {
		cout << "OddMin=No," << endl;
		cout << "OddMax=No," << endl;
	} else {
		cout << "OddMin=" << oddMin << "," << endl;
		cout << "OddMax=" << oddMax << "," << endl;
	}
	cout << "EvenSum=" << evenSum << "," << endl;
	if (evenSum == 0) {
		cout << "EvenMin=No," << endl;
		cout << "EvenMax=No" << endl;
	} else {
		cout << "EvenMin=" << evenMin << "," << endl;
		cout << "EvenMax" << evenMax << endl;
	}
	
	return 0;
}
