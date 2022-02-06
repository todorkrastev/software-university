#include <iostream>
#include <string>
using namespace std;

int main() {
	string command;
	cin >> command;

	cout.setf(ios::fixed);
	cout.precision(2);

	double sum = 0.0;
	while (command != "NoMoreMoney") {
		double currValue = stod(command);

		if (currValue < 0) {
			cout << "Invalid operation!" << endl;
			break;
		}

		sum += currValue;
		cout << "Increase: " << currValue << endl;

		cin >> command;
	}

	cout << "Total: " << sum << endl;
	
	return 0;
}
