#include <iostream>
#include <vector>
#include <string>

#include <thread>
#include <chrono>

#include "RenderingUtils.h"
#include "Organism.h"
#include "Cat.h"
#include "Mouse.h"

class Loader {
public:
	std::vector<Organism*> load() {
		return { 
			new Cat(Position(0, 0)),
			new Mouse(Position(0, 0))
		};
	}
};

const int WORLD_SIZE = 30;

int Position::MinPosition = 0;
int Position::MaxPosition = WORLD_SIZE - 1;

int main() {
	Renderer r(WORLD_SIZE);
	std::vector<Organism*> organisms = Loader().load();

	while (true) {
		for (auto o : organisms) {
			o->act();
		}

		for (auto o : organisms) {
			r.render(o->getPosition(), o->getImage());
		}

		r.flushToScreen();

		std::this_thread::sleep_for(std::chrono::milliseconds(100));
	}

	return 0;
}