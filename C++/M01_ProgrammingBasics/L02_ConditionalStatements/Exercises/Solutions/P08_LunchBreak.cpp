#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>
using namespace std;

int main() {

	string series, strLenOfSerie, strLenOfBrake;
	getline(cin, series);
	getline(cin, strLenOfSerie);
	int lenOfSerie = stoi(strLenOfSerie);
	getline(cin, strLenOfBrake);
	int lenOfBrake = stoi(strLenOfBrake);

	double lenOfLunch = static_cast<double>(lenOfBrake) / 8;
	double lenOfRest = static_cast<double>(lenOfBrake) / 4;

	double freeTime = lenOfBrake - lenOfLunch - lenOfRest;

	double diff = abs(lenOfSerie - freeTime);

	if (lenOfSerie <= freeTime) {
		cout << "You have enough time to watch " << series << " and left with " << ceil(diff) << " minutes free time." << endl;
	} else {
		cout << "You don't have enough time to watch " << series << ", you need " << ceil(diff) << " more minutes." << endl;
	}

	return 0;
}
