#ifndef ORGANISM_H
#define ORGANISM_H

#include <string>

class Organism {
protected:
	std::string name;
	Position position;
public:
	Organism(std::string name, Position p) : name(name), position(p) {}

	virtual void act() = 0;

	virtual std::string getImage() const = 0;

	Position getPosition() const {
		return this->position;
	}
};

#endif // !ORGANISM_H

