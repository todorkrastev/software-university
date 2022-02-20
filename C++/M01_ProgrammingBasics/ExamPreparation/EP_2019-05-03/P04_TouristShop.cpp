#include <iostream>
#include <string>

using namespace std;

int main() {

	// every third item is with 50% discount

	double budget;
	cin >> budget;

	string command;
	getline(cin >> ws, command);
	double price;

	double totalPurchases = 0.0;
	int count = 0;

	cout.setf(ios::fixed);
	cout.precision(2);

	while (command != "Stop") {
		cin >> price;
		count++;

		if (count % 3 == 0) {
			price *= 0.5;
		}
		totalPurchases += price;

		if (budget < totalPurchases) {
			cout << "You don't have enough money!" << endl;
			cout << "You need " << totalPurchases - budget << " leva!" << endl;

			return 0;
		}
		getline(cin >> ws, command);
	}

	cout << "You bought " << count << " products for " << totalPurchases << " leva." << endl;

	return 0;
}
