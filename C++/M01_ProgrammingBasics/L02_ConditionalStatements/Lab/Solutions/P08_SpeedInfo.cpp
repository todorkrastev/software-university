#include <iostream>
#include <string>
using namespace std;

int main() {

	double speed;
	cin >> speed;

	string result;
	if (speed <= 10) {
		result = "slow";
	} else if (10 < speed && speed <= 50) {
		result = "average";
	} else if (50 < speed && speed <= 150) {
		result = "fast";
	} else if (150 < speed && speed <= 1000) {
		result = "ultra fast";
	} else {
		result = "extremely fast";
	}

	cout << result << endl;

	return 0;
}
