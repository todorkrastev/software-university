#include <iostream>
#include <string>
#include <set>

#include "Song.h"
#include "Parser.h"
#include "Comparators.h"
#include "PrintUtils.h"

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
		typedef std::set<int, Reverse<int, LessThan<int> > > Set;
		Set numbers;
		while (p.readNext(n)) {
			numbers.insert(n);
		}
		printContainer<Set>(numbers.begin(), numbers.end());
	}
	else if (type == 'w') {
		Parser<std::string> p(std::cin, stopLine);
		std::string w;
		typedef std::set<std::string, Reverse<std::string, LessThan<std::string> > > Set;
		Set words;
		while (p.readNext(w)) {
			words.insert(w);
		}
		printContainer<Set>(words.begin(), words.end());
	}
	else if (type == 's') {
		Parser<Song> p(std::cin, stopLine);
		Song s;
		typedef std::set<Song, Reverse<Song, LessThan<Song> > > Set;
		Set songs;
		while (p.readNext(s)) {
			songs.insert(s);
		}
		printContainer<Set>(songs.begin(), songs.end());
	}
	else {
		std::cout << "[invalid input]" << std::endl;
	}

	return 0;
}