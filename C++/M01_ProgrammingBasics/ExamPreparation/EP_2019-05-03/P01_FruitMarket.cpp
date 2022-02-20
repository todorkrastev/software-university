#include <iostream>

using namespace std;

int main() {

	double strawberriesPrice, bananasQuantity, orangesQuantity, raspberriesQuantity, strawberriesQuantity;
	cin >> strawberriesPrice >> bananasQuantity >> orangesQuantity >> raspberriesQuantity >> strawberriesQuantity;

	double raspberriesPrice = strawberriesPrice * 0.5;
	double orangesPrice = raspberriesPrice * 0.6;
	double bananasPrice = raspberriesPrice * 0.2;

	double strawberriesTotal = strawberriesPrice * strawberriesQuantity;
	double bananasTotal = bananasPrice * bananasQuantity;
	double orangesTotal = orangesPrice * orangesQuantity;
	double raspeberriesTotal = raspberriesPrice * raspberriesQuantity;

	double totalPrice = strawberriesTotal + bananasTotal + orangesTotal + raspeberriesTotal;

	cout.setf(ios::fixed);
	cout.precision(2);

	cout << totalPrice << endl;


	return 0;
}
