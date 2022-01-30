#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int main() {

	int numOfTournaments, points;
	cin >> numOfTournaments >> points;

	int currPointsSeason = 0;
	int wins = 0;

	string input;
	for (int i = 0; i < numOfTournaments; i++) {
		cin >> input;

		if (input == "W") {
			points += 2000;
			currPointsSeason += 2000;
			wins++;
		} else if (input == "F") {
			points += 1200;
			currPointsSeason += 1200;
		} else if (input == "SF") {
			points += 720;
			currPointsSeason += 720;
		}
	}
	double avgPoints = static_cast<double>(currPointsSeason) / numOfTournaments;
	cout << "Final points: " << points << endl;
	cout << "Average points: " << floor(avgPoints) << endl;
	
	cout.setf(ios::fixed);
	cout.precision(2);

	cout << (static_cast<double>(wins) / numOfTournaments) * 100 << "%" << endl;

	return 0;
}
