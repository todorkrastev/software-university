#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {

	string strBudget, season, strFishermen;
	getline(cin, strBudget);
	int budget = stoi(strBudget);
	getline(cin, season);
	getline(cin, strFishermen);
	int fishermen = stoi(strFishermen);


	double priceBoat;
	if (season == "Spring") {
		priceBoat = 3000;
	} else if (season == "Summer") {
		priceBoat = 4200;
	} else if (season == "Autumn") {
		priceBoat = 4200;
	} else if (season == "Winter") {
		priceBoat = 2600;
	}

	double discount = 1;
	if (fishermen <= 6) {
		discount = 0.9;
	} else if (7 < fishermen && fishermen <= 11) {
		discount = 0.85;
	} else if (12 < fishermen) {
		discount = 0.75;
	}

	double totalPrice = priceBoat * discount;

	if (fishermen % 2 == 0 && season != "Autumn") {
		double additionalDiscount = 0.95;
		totalPrice *= additionalDiscount;
	}

	cout.setf(ios::fixed);
	cout.precision(2);

	double diff = abs(totalPrice - budget);
	if (totalPrice <= budget) {
		cout << "Yes! You have " << diff << " leva left.";
	} else {
		cout << "Not enough money! You need " << diff << " leva.";
	}

	return 0;
}
