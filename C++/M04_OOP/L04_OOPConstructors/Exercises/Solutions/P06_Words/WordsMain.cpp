#include <iostream>
#include <string>
#include <sstream>
#include <set>

#include "Word.h"

std::ostream& operator<<(std::ostream& out, const Word& w) {
	return out << w.getWord() << " " << w.getCount();
}

void printWordCounts(const std::string &line) {
	std::istringstream lineIn(line);
	std::set<Word> words;
	std::string wordStr;
	while (lineIn >> wordStr) {
		words.insert(Word(wordStr));
	}

	for (Word w : words) {
		std::cout << w << std::endl;
	}
}

int main() {
	std::string line;

	std::getline(std::cin, line);
	printWordCounts(line);

	std::cout << "---" << std::endl;

	std::getline(std::cin, line);
	printWordCounts(line);

	return 0;
}