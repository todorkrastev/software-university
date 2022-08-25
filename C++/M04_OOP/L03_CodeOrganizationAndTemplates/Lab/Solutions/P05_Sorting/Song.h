#ifndef SONG_H
#define SONG_H

#include <string>

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

// NOTE: this is intentional - it defines an ordering by name, so that you can't use an operator overload to order the Song objects in the task. Think of a different approach
bool operator<(const Song& thiz, const Song& other) {
	return thiz.getLengthSeconds() < other.getLengthSeconds();
}


#endif // !SONG_H

