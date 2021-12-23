#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {

	double rose = 5;
	double dahlia = 3.8;
	double tulip = 2.8;
	double daffodil = 3;
	double gladiolus = 2.5;

	string type, strQuantity, strBudget;
	getline(cin, type);
	getline(cin, strQuantity);
	int quantity = stoi(strQuantity);
	getline(cin, strBudget);
	int budget = stoi(strBudget);

	double price;
	double percentage = 1;
	if (type == "Roses") {
		price = rose;
		if (80 < quantity) {
		    percentage = 0.9;
		}
	} else if (type == "Dahlias") {
		price = dahlia;
		if (90 < quantity) {
			percentage = 0.85;
		}
	} else if (type == "Tulips") {
		price = tulip;
		if (80 < quantity) {
			percentage = 0.85;
		}
	} else if (type == "Narcissus") {
		price = daffodil;
		if (quantity < 120) {
			percentage = 1.15;
		}
	} else if (type == "Gladiolus") {
		price = gladiolus;
		if (quantity < 80) {
			percentage = 1.2;
		}
	}

	double totalPrice = quantity * price * percentage;

	cout.setf(ios::fixed);
	cout.precision(2);

	double diff = abs(totalPrice - budget);
	if (totalPrice <= budget) {
		cout << "Hey, you have a great garden with " << quantity << " " << type << " and " << diff << " leva left.";
	} else {
		cout << "Not enough money, you need " << diff << " leva more.";
	}

	return 0;
}
