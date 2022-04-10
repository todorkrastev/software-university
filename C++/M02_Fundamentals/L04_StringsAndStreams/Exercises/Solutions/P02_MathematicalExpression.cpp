#include <iostream>
#include <string>
#include <sstream>

using namespace std;


int main() {

	string str;
	getline(cin, str);

	istringstream stream(str);
	char c;
	int depth = 0;

	while (stream >> c) {
		switch (c) {
		case '(': depth++;
			break;
		case ')': depth--;
			break;
		default:
			break;
		}
	}

	cout << (depth == 0 ? "correct" : "incorrect") << endl;

	return 0;
}