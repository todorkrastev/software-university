#include "Join.h"
#include "Split.h"

#include <iostream>
#include <string>
#include <vector>

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
	std::string separatorLine;
	std::getline(std::cin, separatorLine);
	char separator = separatorLine[0];

	std::string line;
	std::getline(std::cin, line);

	char type; 
	std::string joinStr;
	std::cin >> type >> joinStr;

	std::string joined = "";
	if (type == 'i') {
		std::vector<int> numbers = split<int>(line, separator);
		joined = join(numbers, joinStr);
	}
	else if (type == 'w') {
		std::vector<std::string> words = split<std::string>(line, separator);
		joined = join(words, joinStr);
	}
	else if (type == 's') {
		std::vector<Song> songs = split<Song>(line, separator);
		joined = join(songs, joinStr);
	}
	else {
		std::cout << "[invalid input]" << std::endl;
	}

	std::cout << joined << std::endl;

	return 0;
}