#include <iostream>
#include <string>
using namespace std;

int main() {

	double premiere = 12;
	double normal = 7.5;
	double discount = 5;

	string type, strR, strC;
	getline(cin, type);
	getline(cin, strR);
	int rows = stoi(strR);
	getline(cin, strC);
	int cols = stoi(strC);

	double income = 0.0;
	if (type == "Premiere") {
		income = premiere * rows * cols;
	} else if (type == "Normal") {
		income = normal * rows * cols;
	} else if (type == "Discount") {
		income = discount * rows * cols;
	}

	cout.setf(ios::fixed);
	cout.precision(2);

	cout << income << " leva" << endl;

	return 0;
}
