#include <iostream>
#include <sstream>
#include <list>

using namespace std;

list<char> brackets;

bool isCurvedBracketAllowed() {
	return true;
}

bool isSquareBracketAllowed() {

	if (brackets.size() == 0) {
		return true;
	}

	list<char>::iterator itB = brackets.end();
	itB--;

	while (true) {

		if (*itB == '(') {
			return false;
		}

		if (itB == brackets.begin()) {
			break;
		}

		itB--;
	}

	return true;
}

bool isCurlyBracketAllowed() {

	if (brackets.size() == 0) {
		return true;
	}

	list<char>::iterator itB = brackets.end();
	itB--;

	while (true) {

		if (*itB == '(' || *itB == '[') {
			return false;
		}

		if (itB == brackets.begin()) {
			break;
		}

		itB--;
	}

	return true;
}

bool isOpeningBracketAllowed(char bracket) {

	switch (bracket) {
	case '(': return isCurvedBracketAllowed();
	case '[': return isSquareBracketAllowed();
	case '{': return isCurlyBracketAllowed();
	default: return false;
	}

	return true;
}

bool popBracket(char bracket) {

	if (brackets.size() == 0) {
		return false;
	}

	char back = brackets.back();
	brackets.pop_back();

	if (bracket == ')' && back == '(') {
		return true;
	}
	if (bracket == ']' && back == '[') {
		return true;
	}
	if (bracket == '}' && back == '{') {
		return true;
	}

	return false;
}


bool isCorrectSequence(const string& line) {

	for (char buf : line) {

		switch (buf) {
		case '(':
		case '[':
		case '{':

			if (!isOpeningBracketAllowed(buf)) {
				return false;
			}

			brackets.push_back(buf);
			break;

		case ')':
		case ']':
		case '}':

			if (!popBracket(buf)) {
				return false;
			}

			break;

		default: return false;
		}
	}

	return true;
}


int main() {

	string line;
	cin >> line;

	cout << (isCorrectSequence(line) ? "valid" : "invalid") << endl;


	return 0;
}