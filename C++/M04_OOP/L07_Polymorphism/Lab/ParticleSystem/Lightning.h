#ifndef LIGHTNING_H
#define LIGHTNING_H

#include "Particle.h"

class Lightning : public Particle {
	class Spark : public Particle {
	public:
		Spark(Position p, bool right) : Particle(p, right ? '>' : '<', 0) {}
	};

	int length;
public:
	Lightning(Position start, int length) : Particle(start, ' ', 1), length(length) {}

	virtual void update(std::list<Particle*>& producedParticlesOutput) override {
		Particle::update(producedParticlesOutput);

		Position nextPosition = this->position;
		for (int i = 0; i < length; i++) {
			bool right = rand() % 2;

			producedParticlesOutput.push_back(new Spark(nextPosition, right));

			if (right) {
				nextPosition = nextPosition.nextRow().nextCol();
			}
			else {
				nextPosition = nextPosition.nextRow().prevCol();
			}
		}
	}
};

#endif // !LIGHTNING_H

