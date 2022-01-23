#include <iostream>
#include <string>
using namespace std;

int main() {

	double room = 18;
	double appartment = 25;
	double presidentApoartment = 35;

	string strDays, type, review;
	getline(cin, strDays);
	int days = stoi(strDays);
	getline(cin, type);
	getline(cin, review);

	int nights = days - 1;

	double totalPrice = 0.0;
	double discount;

	if (type == "apartment") {
		if (nights < 10) {
			discount = 70;
		}
		else if (10 <= nights && nights <= 15) {
			discount = 65;
		}
		else if (15 < nights) {
			discount = 50;
		}
		totalPrice = appartment * nights * discount / 100;
	}
	else if (type == "president apartment") {
		if (nights < 10) {
			discount = 90;
		}
		else if (10 <= nights && nights <= 15) {
			discount = 85;
		}
		else if (15 < nights) {
			discount = 80;
		}
		totalPrice = presidentApoartment * nights * discount / 100;
	}
	else if (type == "room for one person") {
		totalPrice = room * nights;
	}

	if (review == "positive") {
		totalPrice *= 1.25;
	}
	else if (review == "negative") {
		totalPrice *= 0.9;
	}

	cout.setf(ios::fixed);
	cout.precision(2);

	cout << totalPrice << endl;


	return 0;
}