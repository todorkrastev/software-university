#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main() {

	string command;
	cin >> command;
	int n = stoi(command);
	int minNum = INT16_MAX;

	while (command != "Stop") {
		int currNum = stoi(command);
		minNum = min(minNum, currNum);
		cin >> command;
	}

	cout << minNum << endl;

	return 0;
}
