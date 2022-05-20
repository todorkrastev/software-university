#include <iostream>
#include <set>
#include <string>
#include <sstream>

int main() {
	using namespace std;

	set<int> digits{ 4, 1, 4, 0, 2, 6, 9, 1, 8, 6, 2, 3, 5, 6, 7 };

	for (int d : digits) {
		cout << d << " ";
	}
	cout << endl << endl;

	set<char> letters;
	string sentence = "the quick brown fox jumps over the lazy dog";
	istringstream sentenceIn(sentence);
	char letter;
	while (sentenceIn >> letter) {
		letters.insert(letter);
	}

	bool allEnglishLettersFound = true;
	for (char c = 'a'; c <= 'z'; c++) {
		if (letters.find(c) == letters.end()) {
			// we didn't find the current letter
			allEnglishLettersFound = false;
			break;
		}
	}

	cout << "Does \"" << sentence << "\" contain all English letters?" << endl;
	if (allEnglishLettersFound) {
		cout << "Yes" << endl;
	} else {
		cout << "No" << endl;
	}

	cout << endl;

	return 0;
}