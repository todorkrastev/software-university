#ifndef STICK_H
#define STICK_H

class Stick {
	mutable int position;
	mutable int rotation;
public:
	Stick() : position(0), rotation(0) {}

	int getPosition() const {
		return this->position;
	}

	char nextAnimation() const {
		this->rotation++;

		if (this->rotation == 4) {
			this->rotation = 0;
		}

		switch (rotation) {
		case 0:
			return '_';
		case 1:
			return '\\';
		case 2:
			position++;
			return '|';
		case 3:
			return '/';
		}
	}
};

#endif // !STICK_H

