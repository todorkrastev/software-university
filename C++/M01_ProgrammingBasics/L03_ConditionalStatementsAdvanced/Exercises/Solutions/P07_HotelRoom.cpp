#include <iostream>
#include <string>
using namespace std;

int main() {

	string month;
	int nights;
	cin >> month >> nights;

	double studioPrice = 0.0;
	double appartmentPrice = 0.0;
	if (month == "May" || month == "October") {
		studioPrice = 50;
		appartmentPrice = 65;

		if (7 < nights && nights <= 14) {
			studioPrice *= 0.95;
		} else if (14 < nights) {
			studioPrice *= 0.7;
			appartmentPrice *= 0.9;
		}
	} else if (month == "June" || month == "September") {
		studioPrice = 75.2;
		appartmentPrice = 68.7;

		if (14 < nights) {
			studioPrice *= 0.8;
			appartmentPrice *= 0.9;
		}
	} else if (month == "July" || month == "August") {
		studioPrice = 76;
		appartmentPrice = 77;

		if (14 < nights) {
			appartmentPrice *= 0.9;
		}
	}

	cout.setf(ios::fixed);
	cout.precision(2);

	cout << "Apartment: " << appartmentPrice * nights << " lv." << endl;
	cout << "Studio: " << studioPrice * nights << " lv." << endl;

	return 0;
}
