#ifndef MOUSE_H
#define MOUSE_H

#include "Organism.h"
#include "Position.h"
#include <string>

class Mouse : public Organism {
	int diagonal;
	bool stopped;
	int actsInCurrentState;

	std::string name;
	Position position;
protected:
	void move() {
		switch (this->diagonal) {
		case 0:
			this->position = Position(this->position.getRow() - 1, this->position.getCol() + 1);
			break;
		case 1:
			this->position = Position(this->position.getRow() - 1, this->position.getCol() - 1);
			break;
		case 2:
			this->position = Position(this->position.getRow() + 1, this->position.getCol() - 1);
			break;
		case 3:
			this->position = Position(this->position.getRow() + 1, this->position.getCol() + 1);
			break;
		default:
			break;
		}
	}

public:
	Mouse(Position p) : name("mouse"), position(p), diagonal(rand() % 4), stopped(rand() % 2), actsInCurrentState(0) {}

	Position getPosition() const {
		return this->position;
	}

	void act() {
		actsInCurrentState++;
		if (rand() % 100 < actsInCurrentState) {
			this->stopped = rand() % 2;

			this->diagonal = rand() % 4;
			this->actsInCurrentState = 0;
		}

		if (!this->stopped) {
			this->move();
		}
	}

	std::string getImage() const {
		if (this->diagonal == 0 || this->diagonal == 3) {
			if (this->stopped) {
				return "~~(__^->";
			} else {
				return "~~(__^o>";
			}
		}
		else {
			if (this->stopped) {
				return "<-^__)~~";
			}
			else {
				return "<o^__)~~";
			}
		}
	}
};

#endif // !MOUSE_H

