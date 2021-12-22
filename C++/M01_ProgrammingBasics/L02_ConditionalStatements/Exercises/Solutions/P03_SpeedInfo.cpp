#include <iostream>
using namespace std;

int main() {

	double speed;
	cin >> speed;

	string output;
	if (speed <= 10) {
		output = "slow";
	} else if (10 < speed && speed <= 50) {
		output = "average";
	} else if (50 < speed && speed <= 150) {
		output = "fast";
	} else if (150 < speed && speed <= 1000) {
		output = "ultra fast";
	} else if (1000 < speed) {
		output = "extremely fast";
	}

	cout << output << endl;

	return 0;
}
