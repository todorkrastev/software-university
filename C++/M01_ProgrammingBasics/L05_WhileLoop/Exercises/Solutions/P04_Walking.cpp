#include <iostream>
#include <string>
using namespace std;

int main() {

	string command;
	int goal = 10000;
	int step;

	while (goal > 0) {
		getline(cin >> ws, command);
		if (command == "Going home") {
			cin >> command;
			step = stoi(command);
			goal -= step;
			if (goal > 0) {
				cout << goal << " more steps to reach goal." << endl;
			}
			break;
		}
		step = stoi(command);
		goal -= step;
	}
	if (goal <= 0) {
		cout << "Goal reached! Good job!" << endl;
	}

	return 0;
}
