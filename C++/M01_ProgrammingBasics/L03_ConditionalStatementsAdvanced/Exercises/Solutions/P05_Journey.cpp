#include <iostream>
#include <string>
using namespace std;

int main() {

	string strBudget, season;
	getline(cin, strBudget);
	double budget = stod(strBudget);
	getline(cin, season);

	string destination;
	string type;
	if (budget <= 100) {
		destination = "Bulgaria";
		if (season == "summer") {
			budget *= 0.3;
			type = "Camp";
		} else if (season == "winter") {
			budget *= 0.7;
			type = "Hotel";
		}
	} else if (100 < budget && budget <= 1000) {
		destination = "Balkans";
		if (season == "summer") {
			budget *= 0.4;
			type = "Camp";
		}
		else if (season == "winter") {
			budget *= 0.8;
			type = "Hotel";
		}
	} else if (1000 < budget) {
		destination = "Europe";
		budget *= 0.9;
		type = "Hotel";
	}

	cout << "Somewhere in " << destination << endl;

	cout.setf(ios::fixed);
	cout.precision(2);

	cout << type << " - " << budget << endl;

	return 0;
}
