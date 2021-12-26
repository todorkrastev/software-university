#include <iostream>
using namespace std;

int main() {

	int n;
	double salary;
	cin >> n >> salary;

	for (int i = 0; i < n; i++) {
		string input;
		cin >> input;

		if (0 < salary) {
			if (input == "Facebook") {
				salary -= 150;
			} else if (input == "Instagram") {
				salary -= 100;
			} else if (input == "Reddit") {
				salary -= 50;
			}
		}
		if (salary <= 0) {
			cout << "You have lost your salary." << endl;
			
			return 0;
		}
	}

	cout.setf(ios::fixed);
	cout.precision(0);

	cout << salary << endl;

	return 0;
}
