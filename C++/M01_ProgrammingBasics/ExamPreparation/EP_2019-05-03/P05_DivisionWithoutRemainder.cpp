#include <iostream>

using namespace std;

int main() {

	int num;
	cin >> num;

	int c2 = 0;
	int c3 = 0;
	int c4 = 0;

	int input;
	for (int i = 0; i < num; i++) {
		cin >> input;

		if (input % 2 == 0) {
			c2++;
		}
		if (input % 3 == 0) {
			c3++;
		}
		if (input % 4 == 0) {
			c4++;
		}
	}

	cout.setf(ios::fixed);
	cout.precision(2);

	cout << static_cast<double>(c2) / num * 100 << "%" << endl;
	cout << static_cast<double>(c3) / num * 100 << "%" << endl;
	cout << static_cast<double>(c4) / num * 100 << "%" << endl;

	return 0;
}
