#ifndef PARTICLE_H
#define PARTICLE_H

#include <list>

#include "Position.h"

class Particle {
protected:
	Position position;
	char symbol;
	int updatesRemaining;
public:
	Particle(Position position, char symbol, int updatesRemaining)
		: position(position), symbol(symbol), updatesRemaining(updatesRemaining) {}

	virtual void update(std::list<Particle*>& producedParticlesOutput) {
		this->updatesRemaining--;
	}

	bool exists() const {
		return this->updatesRemaining > 0;
	}

	Position getPosition() const {
		return this->position;
	}

	char getPixel() const {
		return this->symbol;
	}
};


#endif // !PARTICLE_H