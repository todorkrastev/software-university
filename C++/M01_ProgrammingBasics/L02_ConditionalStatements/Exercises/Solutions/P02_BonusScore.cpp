#include <iostream>
using namespace std;

int main() {

	int initPoints;
	cin >> initPoints;

	double bonus;
	if (initPoints <= 100) {
		bonus = 5;
	} else if (1000 < initPoints) {
		bonus = initPoints * 0.1;
	} else {
		bonus = initPoints * 0.2;
	}

	if (initPoints % 2 == 0) {
		bonus += 1;
	}

	if (initPoints % 10 == 5) {
		bonus += 2;
	}

	cout << bonus << endl;
	cout << initPoints + bonus << endl;

	return 0;
}
