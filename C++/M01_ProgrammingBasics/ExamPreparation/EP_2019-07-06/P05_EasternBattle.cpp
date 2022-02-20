#include <iostream>
#include <string>
using namespace std;

int main() {
	int countFirst, countSecond;
	cin >> countFirst; 
	cin >> countSecond;

	cin.ignore();
	string input;
	getline(cin, input);

	while (input != "End of battle") {
		if (input == "one") {
			countSecond--;
		} else if (input == "two") {
			countFirst--;
		}

		if (countFirst == 0) {
			cout << "Player one is out of eggs. Player two has " << countSecond << " eggs left.";
			break;
		} else if (countSecond == 0) {
			cout << "Player two is out of eggs. Player one has " << countFirst << " eggs left.";
			break;
		}

		getline(cin, input);
	}

	if (input == "End of battle") {
		cout << "Player one has " << countFirst << " eggs left." << endl;
		cout << "Player two has " << countSecond << " eggs left.";
	}

	return 0;
}