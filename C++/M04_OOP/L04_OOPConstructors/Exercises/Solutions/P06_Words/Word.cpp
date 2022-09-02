#include "Word.h"

std::map<std::string, int> Word::WordObjectsCounts = std::map<std::string, int>();
std::map<std::string, int> Word::WordCounts = std::map<std::string, int>();

Word::Word(std::string str) : str(str) {
	WordObjectsCounts[str]++;
	WordCounts[str]++;
}

Word::Word(const Word& other) {
	this->str = other.str;
	WordObjectsCounts[str]++;
}

std::string Word::getWord() const {
	return this->str;
}

size_t Word::getCount() const {
	return WordCounts[this->str];
}

bool Word::operator<(const Word& other) const {
	return this->str < other.str;
}

Word& Word::operator=(const Word& other) {
	if (this != &other) {
		this->str = other.str;
		WordObjectsCounts[this->str]++;
	}

	return *this;
}

Word::~Word() {
	int remaining = --(WordObjectsCounts[this->str]);
	if (remaining == 0) {
		WordCounts[this->str] = 0;
	}
}