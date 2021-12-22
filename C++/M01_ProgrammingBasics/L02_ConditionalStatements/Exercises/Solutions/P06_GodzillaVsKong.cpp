#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {

	double budget, clothingPricePerWalkOn;
	int walkOnQuantity;

	cin >> budget >> walkOnQuantity >> clothingPricePerWalkOn;

	double decor = budget * 0.1;

	if (150 < walkOnQuantity) {
		clothingPricePerWalkOn *= 0.9;
	}

	cout.setf(ios::fixed);
	cout.precision(2);

	double clothingExpenses = walkOnQuantity * clothingPricePerWalkOn;
	double movieExpenses = decor + clothingExpenses;

	double amount = abs(budget - movieExpenses);
	if (movieExpenses <= budget) {
		cout << "Action!" << endl;
		cout << "Wingard starts filming with " << amount << " leva left." << endl;
	} else {
		cout << "Not enough money!" << endl;
		cout << "Wingard needs " << amount << " leva more." << endl;
	}

	return 0;
}
