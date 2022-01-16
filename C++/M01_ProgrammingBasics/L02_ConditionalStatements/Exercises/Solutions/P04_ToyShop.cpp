#include <iostream>
#include <cmath>
using namespace std;

int main() {

	double puzzlePrice = 2.6;
	double dollPrice = 3;
	double teddyBearPrice = 4.1;
	double minionPrice = 8.2;
	double truckPrice = 2;

	double tripPrice;
	int puzzleQuantity, dollQuantity, teddyBearQuantity, minionQuantity, truckQuantity;
	cin >> tripPrice >> puzzleQuantity >> dollQuantity >> teddyBearQuantity >> minionQuantity >> truckQuantity;

	double puzzleIncome = puzzlePrice * puzzleQuantity;
	double dollIncome = dollPrice * dollQuantity;
	double teddyBearIncome = teddyBearPrice * teddyBearQuantity;
	double minionIncome = minionPrice * minionQuantity;
	double truckIncome = truckPrice * truckQuantity;

	double totalIncome = puzzleIncome + dollIncome + teddyBearIncome + minionIncome + truckIncome;

	int toysTotalQuantity = puzzleQuantity + dollQuantity + teddyBearQuantity + minionQuantity + truckQuantity;

	if (50 <= toysTotalQuantity) {
		totalIncome *= 0.75;
	}

	double rent = totalIncome * 0.1;

	double profit = totalIncome - rent;

	cout.setf(ios::fixed);
	cout.precision(2);

	double output = abs(profit - tripPrice);
	if (tripPrice <= profit) {
		cout << "Yes! " << output << " lv left.";
	} else {
		cout << "Not enough money! " << output << " lv needed.";
	}


	return 0;
}
