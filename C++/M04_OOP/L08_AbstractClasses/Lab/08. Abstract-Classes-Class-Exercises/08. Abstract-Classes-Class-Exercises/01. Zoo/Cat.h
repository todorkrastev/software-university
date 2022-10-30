#ifndef CAT_H
#define CAT_H

#include "Organism.h"
#include <climits>

class Cat : public Organism {
	int actsPerMove;
	int actsSinceLastMove;
	int actsInCurrentState;

	const int FAST_MOVE_ACTS = 1;
	const int SLOW_MOVE_ACTS = 4;
	const int NOT_MOVING_ACTS = LONG_MAX;
protected:
	virtual void move() {
		int rowMove = (rand() % 3) - 1;
		int colMove = (rand() % 3) - 1;

		this->position = Position(this->position.getRow() + rowMove, this->position.getCol() + colMove);
		this->actsSinceLastMove = 0;
	}

	virtual void changeMovement() {
		this->actsInCurrentState = 0;
		int actsPerMoveChange = rand() % 3;
		switch (actsPerMoveChange) {
		case 0:
			this->actsPerMove = NOT_MOVING_ACTS;
			break;
		case 1:
			this->actsPerMove = SLOW_MOVE_ACTS;
			break;
		case 2:
			this->actsPerMove = FAST_MOVE_ACTS;
			break;
		}
	}
public:
	Cat(Position p) : Organism("cat", p), actsPerMove(NOT_MOVING_ACTS), actsSinceLastMove(0), actsInCurrentState(0) {}

	virtual void act() override {
		this->actsSinceLastMove++;
		if (this->actsSinceLastMove >= this->actsPerMove) {
			move();
		}

		this->actsInCurrentState++;
		// 1% chance per act for the cat to change its movement, increased by the number of acts elapsed
		// - i.e. the longer it stays in the same state, the more likely it is to change speed
		if ((rand() % 100) < 1 + (this->actsInCurrentState)) {
			changeMovement();
		}
	}

	virtual std::string getImage() const override {
		if (this->actsPerMove == NOT_MOVING_ACTS && this->actsSinceLastMove % 10 < 3) {
			// make the cat blink once in a while when stationary:
			return "=^--^=";
		}
		else {
			return "=^..^=";
		}
	}
};

#endif // !CAT_H

