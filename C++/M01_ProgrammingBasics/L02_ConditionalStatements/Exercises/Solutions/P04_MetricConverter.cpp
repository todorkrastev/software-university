#include <iostream>
using namespace std;

int main() {

	double num;
	string inputMeasure, outputMeasure;
	cin >> num >> inputMeasure >> outputMeasure;

	if (inputMeasure == "mm") {
		num /= 1000;
	} else if (inputMeasure == "cm") {
		num /= 100;
	}

	if (outputMeasure == "mm") {
		num *= 1000;
	} else if (outputMeasure == "cm") {
		num *= 100;
	}

	cout.setf(ios::fixed);
	cout.precision(3);

	cout << num << endl;

	return 0;
}
