#include <iostream>
#include <algorithm>
using namespace std;

int main() {

	double videoCardPricePerUnit = 250;

	double budget;
	int videoCardsQuantity, processorQuantity, ramQuantity;
	cin >> budget >> videoCardsQuantity >> processorQuantity >> ramQuantity;

	double videoCardsTotalPrice = videoCardPricePerUnit * videoCardsQuantity;
	double processorPricePerUnit = videoCardsTotalPrice * 0.35;
	double proccessorTotalPrice = processorPricePerUnit * processorQuantity;
	double ramPricePerUnit = videoCardsTotalPrice * 0.1;
	double ramTotalPrice = ramPricePerUnit * ramQuantity;

	double totalPrice = videoCardsTotalPrice + proccessorTotalPrice + ramTotalPrice;

	if (processorQuantity < videoCardsQuantity) {
		totalPrice *= 0.85;
	}

	cout.setf(ios::fixed);
	cout.precision(2);

	double diff = abs(budget - totalPrice);

	if (totalPrice <= budget) {
		cout << "You have " << diff << " leva left!" << endl;
	} else {
		cout << "Not enough money!You need " << diff << " leva more!" << endl;
	}

	return 0;
}