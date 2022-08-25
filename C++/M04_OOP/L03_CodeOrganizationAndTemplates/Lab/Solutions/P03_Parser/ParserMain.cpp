#include <iostream>
#include <string>
#include <vector>

#include "Parser.h"
#include "PrintUtils.h"

class Song {
private:
	std::string name;
	int lengthSeconds;
public:
	Song() {}

	Song(std::string name, int lengthSeconds) : name(name), lengthSeconds(lengthSeconds) {}

	std::string getName() const {
		return this->name;
	}

	int getLengthSeconds() const {
		return this->lengthSeconds;
	}
};

std::ostream& operator<<(std::ostream& out, const Song& s) {
	return out << s.getName() << " " << s.getLengthSeconds();
}

std::istream& operator>>(std::istream& in, Song& s) {
	std::string name; int length;
	in >> name >> length;

	s = Song(name, length);
	return in;
}

int main() {
	char type;
	std::cin >> type; std::cin.ignore();
	std::string stopLine;
	std::getline(std::cin, stopLine);

	if (type == 'i') {
		Parser<int> p(std::cin, stopLine);
		int n;
		std::vector<int> numbers;
		while (p.readNext(n)) {
			numbers.push_back(n);
		}
		printVector(numbers);
	}
	else if (type == 'w') {
		Parser<std::string> p(std::cin, stopLine);
		std::string w;
		std::vector<std::string> words;
		while (p.readNext(w)) {
			words.push_back(w);
		}
		printVector(words);
	}
	else if (type == 's') {
		Parser<Song> p(std::cin, stopLine);
		Song s;
		std::vector<Song> songs;
		while (p.readNext(s)) {
			songs.push_back(s);
		}
		printVector(songs);
	}
	else {
		std::cout << "[invalid input]" << std::endl;
	}

	return 0;
}