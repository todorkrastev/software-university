#include <iostream>
#include <string>

using namespace std;

int main() {
	int mens = 15;
	int ladies = 20;
	int kids = 10;
	int touchUp = 20;
	int fullColor = 30;

	int target;
	cin >> target;

	cin.ignore();

	string command;
	getline(cin, command);

	double total = 0.0;
	double bill = 0.0;

	while (command != "closed") {
		if (command == "haircut") {
			getline(cin, command);

			if (command == "mens") {
				bill = mens;
			} else if (command == "ladies") {
				bill = ladies;
			} else if (command == "kids") {
				bill = kids;
			}
		} else if (command == "color") {
			getline(cin, command);

			if (command == "touch up") {
				bill = touchUp;
			} else if (command == "full color") {
				bill = fullColor;
			}
		}

		total += bill;


		if (target <= total) {
			cout << "You have reached your target for the day!" << endl;
			cout << "Earned money: " << total << "lv." << endl;

			return 0;
		}

		getline(cin, command);
	}

	cout << "Target not reached! You need " << target - total << "lv. more." << endl;
	cout << "Earned money: " << total << "lv." << endl;


	return 0;
}