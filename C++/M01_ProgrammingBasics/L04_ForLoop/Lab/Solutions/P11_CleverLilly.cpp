#include <iostream>
#include <algorithm>
using namespace std;

int main() {

	int ageL;
	double priceWM, priceToys;
	cin >> ageL >> priceWM >> priceToys;

	double savings = 0;
	double giftMny = 10;
	int toys = 0;

	for (int i = 1; i <= ageL; i++) {
		if (i % 2 == 0) {
			savings += giftMny - 1;
			giftMny += 10;
		} else {
			toys += 1;
		}
	}
	double totalMny = savings + (toys * priceToys);
	double lackExtraMny = totalMny - priceWM;

	cout.setf(ios::fixed);
	cout.precision(2);

	if (totalMny >= priceWM) {
		cout << "Yes! " << lackExtraMny << endl;
	} else {
		cout << "No! " << abs(lackExtraMny) << endl;
	}

	return 0;
}
