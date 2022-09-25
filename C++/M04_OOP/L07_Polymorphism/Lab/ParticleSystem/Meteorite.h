#ifndef METEORITE_H
#define METEORITE_H

#include <cstdlib>

#include "Particle.h"

class Meteorite : public Particle {
	class Trail : public Particle {
	public:
		Trail(Position p, int lifetime, bool right) : Particle(p, right ? '\\' : '/', lifetime) {}
	};

	int trailLength;
	bool rightDiagonal;
public:
	Meteorite(Position p, int lifetime, int trailLength) 
		: Particle(p, 'o', lifetime), trailLength(trailLength), rightDiagonal(rand() % 2) {}

	virtual void update(std::list<Particle*>& producedParticlesOutput) override {
		Particle::update(producedParticlesOutput);

		Trail* trailPart = new Trail(this->position, this->trailLength, this->rightDiagonal);
		producedParticlesOutput.push_back(trailPart);

		this->position = this->position.nextRow();

		if (this->rightDiagonal) {
			this->position = this->position.nextCol();
		}
		else {
			this->position = this->position.prevCol();
		}
	}
};

#endif // !METEORITE_H

