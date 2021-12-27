#include <iostream>
#include <string>
using namespace std;

int main() {

	string input;
	cin >> input;

	int sum = 0;
	while (input != "Stop") {
		int currNum = stoi(input);
		sum += currNum;
		cin >> input;
	}

	cout << sum << endl;

	return 0;
}
