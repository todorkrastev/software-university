#include <iostream>
using namespace std;

int main() {
	int startNumber, endNumber;
	cin >> startNumber;
	cin >> endNumber;

	for (int number = startNumber; number <= endNumber; number++) {
		int units = number % 10;
		int tens = number / 10 % 10;
		int hundreds = number / 100 % 10;
		int thousands = number / 1000 % 10;
		int tenThousands = number / 10000 % 10;
		int hundredThousands = number / 100000;

		int sumEven = units + hundreds + tenThousands;
		int sumOdd = tens + thousands + hundredThousands;

		if (sumEven == sumOdd) {
			cout << number << " ";
		}
	}
	return 0;
}