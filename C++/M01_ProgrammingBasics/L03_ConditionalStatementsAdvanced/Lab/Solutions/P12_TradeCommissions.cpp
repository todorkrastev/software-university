#include <iostream>
#include <string>
using namespace std;

int main() {

	string town;
	double sales;
	cin >> town >> sales;

	double commission;
	if (town == "Sofia") {
		if (0 <= sales && sales <= 500) {
			commission = 5;
		} else if (500 < sales && sales <= 1000) {
			commission = 7;
		} else if (1000 < sales && sales <= 10000) {
			commission = 8;
		} else if (10000 < sales) {
			commission = 12;
		} else {
			cout << "error" << endl;
			return 0;
		} 
	} else if (town == "Varna") {
		if (0 <= sales && sales <= 500) {
			commission = 4.5;
		} else if (500 < sales && sales <= 1000) {
			commission = 7.5;
		} else if (1000 < sales && sales <= 10000) {
			commission = 10;
		} else if (10000 < sales) {
			commission = 13;
		} else {
			cout << "error" << endl;
			return 0;
		}
	} else if (town == "Plovdiv") {
		if (0 <= sales && sales <= 500) {
			commission = 5.5;
		}
		else if (500 < sales && sales <= 1000) {
			commission = 8;
		}
		else if (1000 < sales && sales <= 10000) {
			commission = 12;
		}
		else if (10000 < sales) {
			commission = 14.5;
		}
		else {
			cout << "error" << endl;
			return 0;
		}
	} else {
		cout << "error" << endl;
		return 0;
	}

	cout.setf(ios::fixed);
	cout.precision(2);

	cout << (commission / 100) * sales << endl;

	return 0;
}
