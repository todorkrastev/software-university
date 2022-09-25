#ifndef RAINDROP_H
#define RAINDROP_H

#include "Particle.h"

class Raindrop : public Particle {
public:
	Raindrop(Position p, int lifetime) : Particle(p, '|', lifetime) {}

	virtual void update(std::list<Particle*>& producedParticlesOutput) override {
		Particle::update(producedParticlesOutput);

		this->position = this->position.nextRow();
	}
};

#endif // !RAINDROP_H

