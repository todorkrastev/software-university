#include <iostream>
using namespace std;

int main() {

	double strawberriesPrice;
	double bananasQuantity, orangesQuantity, raspberriesQuantity, strawberriesQuantity;

	cin >> strawberriesPrice >> bananasQuantity >> orangesQuantity >> raspberriesQuantity >> strawberriesQuantity;

	double raspberriesPrice = strawberriesPrice * 0.5;
	double orangesPrice = raspberriesPrice * 0.6;
	double bananasPrice = raspberriesPrice * 0.2;

	double totalPrice = strawberriesPrice * strawberriesQuantity + bananasPrice * bananasQuantity + orangesPrice * orangesQuantity + raspberriesPrice * raspberriesQuantity;

	cout.setf(ios::fixed);
	cout.precision(2);

	cout << totalPrice << endl;

	return 0;
}
