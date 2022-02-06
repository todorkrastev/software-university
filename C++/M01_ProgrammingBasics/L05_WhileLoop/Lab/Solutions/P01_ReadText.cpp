#include <iostream>
#include <string>
using namespace std;

int main() {

	string input;
	cin >> input;
	while (input != "Stop") {
		cout << input << endl;
		cin >> input;
	}

	return 0;
}
