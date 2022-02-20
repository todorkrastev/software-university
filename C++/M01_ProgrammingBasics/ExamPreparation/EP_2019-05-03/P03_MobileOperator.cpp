#include <iostream>
#include <string>

using namespace std;

int main() {
	string termOfContract, typeOfContract, mobileInternet;
	cin >> termOfContract >> typeOfContract >> mobileInternet;

	int monthlyPaymentsPeriod;
	cin >> monthlyPaymentsPeriod;

	double price = 0.0;

	if (termOfContract == "one") {
		if (typeOfContract == "Small") {
			price = 9.98;
		} else if (typeOfContract == "Middle") {
			price = 18.99;
		} else if (typeOfContract == "Large") {
			price = 25.98;
		} else if (typeOfContract == "ExtraLarge") {
			price = 35.99;
		}
	} else if (termOfContract == "two") {
		if (typeOfContract == "Small") {
			price = 8.58;
		} else if (typeOfContract == "Middle") {
			price = 17.09;
		} else if (typeOfContract == "Large") {
			price = 23.59;
		} else if (typeOfContract == "ExtraLarge") {
			price = 31.79;
		}
	}

	if (mobileInternet == "yes") {
		if (price <= 10) {
			price += 5.5;
		} else if (price <= 30) {
			price += 4.35;
		} else if (price > 30) {
			price += 3.85;
		}
	}

	if (termOfContract == "two") {
		price *= 0.9625;
	}

	cout.setf(ios::fixed);
	cout.precision(2);

	cout << price * monthlyPaymentsPeriod << " lv." << endl;


	return 0;
}
