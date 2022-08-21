#include <cstdlib>
#include <iostream>
#include <string>
#include <list>
#include <thread>

#ifdef __linux__ 
// WARNING: the linux code here is not tested
void clearScreen() {
	// CSI[2J clears screen, CSI[H moves the cursor to top-left corner
	std::cout << "\x1B[2J\x1B[H";
}
#elif _WIN32
#include <Windows.h>
void clearScreen() {
	COORD tl = { 0,0 };
	CONSOLE_SCREEN_BUFFER_INFO s;
	HANDLE console = GetStdHandle(STD_OUTPUT_HANDLE);
	GetConsoleScreenBufferInfo(console, &s);
	DWORD written, cells = s.dwSize.X * s.dwSize.Y;
	FillConsoleOutputCharacter(console, ' ', cells, tl, &written);
	FillConsoleOutputAttribute(console, s.wAttributes, cells, tl, &written);
	SetConsoleCursorPosition(console, tl);
}
#endif

#include "Stick.h"

const int LINE_LENGTH = 50;

void animateSticks(std::list<const Stick*>& sticks) {
	std::string line(LINE_LENGTH, ' ');

	auto i = sticks.begin();
	while (i != sticks.end()) {
		char animation = (*i)->nextAnimation();

		if ((*i)->getPosition() == LINE_LENGTH) {
			delete *i;
			i = sticks.erase(i);
		}
		else {
			int position = (*i)->getPosition();

			line[position] = animation;

			i++;
		}
	}

	clearScreen();
	for (int i = 0; i < LINE_LENGTH; i++) {
		std::cout << line[i];
	}
}

int main() {
	std::list<const Stick*> sticks;

	int newStickChancePct = 5;
	int lastStickGeneratedTime = 0;
	while (true) {
		if (lastStickGeneratedTime > 4 && rand() % 100 <= newStickChancePct) {
			sticks.push_back(new Stick());
			lastStickGeneratedTime = 0;
		}

		animateSticks(sticks);

		std::this_thread::sleep_for(std::chrono::milliseconds(200));
		lastStickGeneratedTime++;
	}
}
