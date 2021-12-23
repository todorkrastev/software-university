#include <iostream>
#include <string>
using namespace std;

int main() {

	string input;
	cin >> input;

	string output;
	if (input == "banana" || input == "apple" || input == "kiwi" || input == "cherry" || input == "lemon" || input == "grapes") {
		output = "fruit";
	} else if (input == "tomato" || input == "cucumber" || input == "pepper" || input == "carrot") {
		output = "vegetable";
	} else {
		output = "unknown";
	}

	cout << output << endl;

	return 0;
}
