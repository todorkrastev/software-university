#include <iostream>
#include <string>

using namespace std;


int main() {

	string input;
	cin >> input;

	int currNum = 0;
	int root = 0;

	for (size_t i = 0; i < input.length(); i++) {
		char ch = input[i];

		if (0 <= ch - 48 && ch - 48 <= 9) {
			int digit = ch - 48;

			currNum *= 10;
			currNum += digit;

		} else {
			string result = currNum > 0 ? string(currNum, ch) : string(1, ch);

			cout << result;

			currNum = 0;
		}
	}

	return 0;
}