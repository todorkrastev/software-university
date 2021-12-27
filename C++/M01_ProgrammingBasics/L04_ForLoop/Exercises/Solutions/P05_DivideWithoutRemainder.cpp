#include <iostream>
using namespace std;

int main() {

	int n;
	cin >> n;

	int count2 = 0;
	int count3 = 0;
	int count4 = 0;
	for (int i = 0; i < n; i++) {
		int input;
		cin >> input;
		if (input % 2 == 0) {
			count2++;
		}
		if (input % 3 == 0) {
			count3++;
		}
		if (input % 4 == 0) {
			count4++;
		}
	}

	cout.setf(ios::fixed);
	cout.precision(2);

	cout << static_cast<double>(count2) / n * 100 << "%" << endl;
	cout << static_cast<double>(count3) / n * 100 << "%" << endl;
	cout << static_cast<double>(count4) / n * 100 << "%" << endl;

	return 0;
}
