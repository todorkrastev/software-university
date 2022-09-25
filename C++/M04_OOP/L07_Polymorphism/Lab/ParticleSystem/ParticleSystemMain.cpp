#include <iostream>
#include <list>
#include <thread>
#include <sstream>
#include <cstdlib>

#include <list>

#include "Particle.h"
#include "ConsoleScreen.h"
#include "Engine.h"

int main() {
	const int width = 20;
	const int height = 20;

	std::list<Particle*> particles;
	auto screen = ConsoleScreen(height, width, ' ');

	bool running = true;
	while (running) {
		generateRandomParticles(particles, width);

		renderParticles(screen, particles);

		std::this_thread::sleep_for(std::chrono::milliseconds(100));

		updateParticles(particles);
	}

	return 0;
}