#include <iostream>
#include <vector>
#include <string>

#include <thread>
#include <chrono>

#include "RenderingUtils.h"
#include "Organism.h"
#include "Cat.h"
#include "Mouse.h"

const int WORLD_SIZE = 30;

int Position::MinPosition = 0;
int Position::MaxPosition = WORLD_SIZE - 1;

int main() {
	Renderer r(WORLD_SIZE);
	
	while (true) {
		r.flushToScreen();

		std::this_thread::sleep_for(std::chrono::milliseconds(100));
	}

	return 0;
}