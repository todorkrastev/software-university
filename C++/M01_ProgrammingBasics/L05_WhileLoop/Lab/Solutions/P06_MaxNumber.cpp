#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main() {

	string command;
	cin >> command;
	int n = stoi(command);
	int maxNum = INT16_MIN;

	while (command != "Stop") {
		int currNum = stoi(command);
		maxNum = max(maxNum, currNum);
		cin >> command;
	}

	cout << maxNum << endl;

	return 0;
}
