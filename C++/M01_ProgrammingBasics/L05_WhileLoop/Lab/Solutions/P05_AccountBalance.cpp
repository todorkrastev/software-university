#include <iostream>
using namespace std;

int main() {

	cout.setf(ios::fixed);
	cout.precision(2);

	int n;
	cin >> n;
	double sum = 0.0;
	double input = 0.0;
	for (int i = 0; i < n; i++) {
		cin >> input;
		if (input <= 0) {
			cout << "Invalid operation!" << endl;
			break;
		}

		cout << "Increase: " << input << endl;
		sum += input;
	}

	cout << "Total: " << sum << endl;

	return 0;
}
