#include <iostream>

using namespace std;

int main() {

	// even day / odd hour - price -> 2.50
	// odd day / even hour - price -> 1.25
	// else - price -> 1.00

	// pricing per hour


	int days, hours;
	cin >> days >> hours;
	double totalPrice = 0.0;
	double currPrice = 0.0;

	cout.setf(ios::fixed);
	cout.precision(2);

	for (int day = 1; day <= days; day++) {
		for (int hour = 1; hour <= hours; hour++) {
			if (day % 2 == 0 && hour % 2 == 1) {
				currPrice += 2.5;
			} else if (day % 2 == 1 && hour % 2 == 0) {
				currPrice += 1.25;
			} else {
				currPrice += 1;
			}
		}

		cout << "Day: " << day << " - " << currPrice << " leva" << endl;
		totalPrice += currPrice;
		currPrice = 0.0;
	}

	cout << "Total: " << totalPrice << " leva" << endl;

	return 0;
}