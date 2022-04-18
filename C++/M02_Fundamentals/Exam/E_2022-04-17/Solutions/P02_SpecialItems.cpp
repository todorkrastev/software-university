#include <iostream>
#include <string>
#include <regex>
#include <vector>

int main() {

	std::string text;
	getline(std::cin, text);

	std::regex regEx("\\s+");
	text = std::regex_replace(text, regEx, " ");

	std::vector<char> refactoredText;

	for (size_t i = 0; i < text.length(); i++) {

		char currSym = text[i];

		if (currSym != 'a' && currSym != 'e' && currSym != 'i' && currSym != 'o' && currSym != 'u' &&
			currSym != 'A' && currSym != 'E' && currSym != 'I' && currSym != 'O' && currSym != 'U') {

			if (i != text.length() - 1) {

				char nextSym = text[i + 1];

				if (currSym != nextSym) {

					refactoredText.push_back(currSym);
				}
			} else {

				refactoredText.push_back(currSym);
			}
		} else {

			refactoredText.push_back(currSym);
		}
	}

	for (std::vector<char>::iterator it = refactoredText.begin(); it != refactoredText.end(); it++) {

		std::cout << *it;
	}

	return 0;
}

// --------------------------------------------------------------------------

// refactoring

// --------------------------------------------------------------------------

#include <iostream>
#include <algorithm>
#include <unordered_set>

bool isMagical(const char ch) {
	static const std::unordered_set<char> magicalItems{ 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' };
	return magicalItems.find(ch) != magicalItems.end();
}

int main() {
	std::string str;
	std::getline(std::cin, str);

	char last = '\0';
	const auto& newEnd = std::remove_if(
		str.begin(), str.end(), [&last](char current) {
			bool remove = current == last && !isMagical(current);
			last = current;
			return remove;
		});

	str.erase(newEnd, str.end());

	std::cout << str << std::endl;

	return 0;
}