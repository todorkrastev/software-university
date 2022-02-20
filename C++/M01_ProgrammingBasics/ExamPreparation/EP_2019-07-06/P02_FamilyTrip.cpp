#include <iostream>
using namespace std;

int main() {
	double budget;
	cin >> budget;

	int countNights;
	cin >> countNights;

	double pricePerNight;
	cin >> pricePerNight;

	int percent;
	cin >> percent;

	if (countNights > 7) {
		pricePerNight = pricePerNight - 0.05 * pricePerNight;
	}

	double sumNights = countNights * pricePerNight;

	double sumAddExpenses = (percent / 100.0) * budget;

	double totalSum = sumNights + sumAddExpenses;

	cout.setf(ios::fixed);
	cout.precision(2);
	if (budget >= totalSum) {
		cout << "Ivanovi will be left with " << budget - totalSum << " leva after vacation.";
	}
	else {
		cout << totalSum - budget << " leva needed.";
	}


	return 0;
}