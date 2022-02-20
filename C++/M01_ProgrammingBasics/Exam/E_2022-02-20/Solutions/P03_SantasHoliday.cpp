#include <iostream>
#include <string>

using namespace std;

int main() {

	double oneRoom = 18;
	double apartment = 25;
	double presidentApartment = 35;

	int days;
	cin >> days;

	int nights = days - 1;

	cin.ignore();
	string roomType, review;

	getline(cin, roomType);
	cin >> review;

	double price = 0.0;


	if (roomType == "room for one person") {
		if (nights < 10) {
			price = oneRoom;
		}
		else if (10 <= nights && nights <= 15) {
			price = oneRoom;
		}
		else if (15 < nights) {
			price = oneRoom;
		}
	}
	else if (roomType == "apartment") {
		if (nights < 10) {
			price = apartment * 0.7;
		}
		else if (10 <= nights && nights <= 15) {
			price = apartment * 0.65;
		}
		else if (15 < nights) {
			price = apartment * 0.5;
		}
	}
	else if (roomType == "president apartment") {
		if (nights < 10) {
			price = presidentApartment * 0.9;
		}
		else if (10 <= nights && nights <= 15) {
			price = presidentApartment * 0.85;
		}
		else if (15 < nights) {
			price = presidentApartment * 0.8;
		}
	}

	price *= nights;

	if (review == "positive") {
		price *= 1.25;
	}
	else if (review == "negative") {
		price *= 0.9;
	}


	cout.setf(ios::fixed);
	cout.precision(2);

	cout << price << endl;


	return 0;
}