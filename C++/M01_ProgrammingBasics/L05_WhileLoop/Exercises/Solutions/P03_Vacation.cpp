#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main() {

	double priceVacation, availableMoney;
	cin >> priceVacation >> availableMoney;

	int savedCounter = 0;
	int spentCounter = 0;

	string command;
	double currMoney = 0;
	while (availableMoney < priceVacation) {
		cin >> command;
		cin >> currMoney;

		if (command == "save") {
			availableMoney += currMoney;
			spentCounter = 0;
		}
		else if (command == "spend") {
			availableMoney = max(availableMoney - currMoney, 0.00);
			spentCounter++;
		}

		savedCounter++;

		if (spentCounter == 5) {
			cout << "You can't save the money." << endl;
			cout << savedCounter << endl;

			return 0;
		}
	}

	cout << "You saved the money for " << savedCounter << " days." << endl;

	return 0;
}
