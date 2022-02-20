#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main() {

	double gasPrice = 2.1;
	double guidePrice = 100;
	// saturday - 10% discount
	// sunday - 20% discount

	double budget, litres;
	cin >> budget >> litres;

	string dayOfWeek;
	cin >> dayOfWeek;

	double gasTotal = gasPrice * litres;
	double totalPrice = guidePrice + gasTotal;

	if (dayOfWeek == "Saturday") {
		totalPrice *= 0.9;
	}
	else if (dayOfWeek == "Sunday") {
		totalPrice *= 0.8;
	}

	cout.setf(ios::fixed);
	cout.precision(2);

	double diff = abs(budget - totalPrice);

	if (totalPrice <= budget) {
		cout << "Safari time! Money left: " << diff << " lv." << endl;
	}
	else {
		cout << "Not enough money! Money needed: " << diff << " lv." << endl;
	}


	return 0;
}
