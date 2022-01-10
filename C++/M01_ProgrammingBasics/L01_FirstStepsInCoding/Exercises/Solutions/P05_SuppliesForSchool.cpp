#include <iostream>
using namespace std;

int main() {

	int pen, marker, cleaner, discount;
	cin >> pen >> marker >> cleaner >> discount;

	double penPrice = 5.8;
	double markerPrice = 7.2;
	double cleanerPrice = 1.2;

	double penTP = pen * penPrice;
	double markerTP = marker * markerPrice;
	double cleanerTP = cleaner * cleanerPrice;

	double totalPrice = (penTP + markerTP + cleanerTP) * 0.75;

	cout << totalPrice << endl;

	return 0;
}
