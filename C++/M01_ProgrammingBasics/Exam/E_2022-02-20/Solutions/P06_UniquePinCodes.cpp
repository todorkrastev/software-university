#include <iostream>

using namespace std;

int main() {
	int firstDigit, secondDigit, thirdDigit;
	cin >> firstDigit >> secondDigit >> thirdDigit;

	for (int f = 1; f <= firstDigit; f++) {
		for (int s = 1; s <= secondDigit; s++) {
			for (int t = 1; t <= thirdDigit; t++) {
				if (f % 2 == 0 && t % 2 == 0  && (s == 2 || s == 3 || s == 5 || s == 7)) {
					cout << f << " " << s << " " << t << endl;
				}
			}
		}
	}


	return 0;
}