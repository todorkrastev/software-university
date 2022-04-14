#include <iostream>
#include <algorithm>
#include <list>
#include <string>

using namespace std;

int main() {

	list<char> alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	string input;
	cin >> input;

	for (size_t i = 0; i < input.size(); i++) {
		if (find(alphabet.begin(), alphabet.end(), input[i]) != alphabet.end()) {
			alphabet.remove(input[i]);
		}	
	}

	
	for (list<char>::iterator it = alphabet.begin(); it != alphabet.end(); ++it) {
		cout << *it;
	}

	cout << endl;


	return 0;
}


// Second Option

/*
#include <iostream>

using namespace std;

const size_t maxInput = 100;


int main() {

	char input[maxInput + 1];
	cin >> input;

	string output("abcdefghijklmnopqrstuvwxyz");

	for (size_t currIndex = 0; input[currIndex] != 0; currIndex++) {
		char currSymbol = input[currIndex];

		string::size_type symbolPosition = output.find(currSymbol);

		if (symbolPosition != string::npos) {
			output.erase(symbolPosition, 1);
		}
	}

	cout << output << endl;

	return 0;
}
*/
