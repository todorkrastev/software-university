#include <iostream>
using namespace std;

int main() {

	double squareMetersForGreening;
	cin >> squareMetersForGreening;

	double priceSquareMeterGreeining = 7.61;

	double totalPrice = priceSquareMeterGreeining * squareMetersForGreening * 0.82;

	double discount = priceSquareMeterGreeining * squareMetersForGreening * 0.18;

	cout.setf(ios::fixed);
	cout.precision(2);

	cout << "The final price is: " << totalPrice << "lv." << endl;
	cout << "The discount is: " << discount << "lv." << endl;
	return 0;
}

