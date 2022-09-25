#ifndef CONSOLE_SCREEN_H
#define CONSOLE_SCREEN_H

#ifdef __linux__
#elif _WIN32
#include <Windows.h>
#endif // __linux__

#include <ostream>
#include <sstream>
#include <iostream>

#include "Screen.h"

class ConsoleScreen : public Screen<char> {
	std::ostream& renderStream;
public:
	ConsoleScreen(int rows, int cols, char background)
		: Screen(rows, cols, background), renderStream(std::cout) {}

	void render() override {
		std::ostringstream renderStream;
		for (auto row : this->renderMatrix) {
			for (auto pixel : row) {
				renderStream << pixel;
			}
			renderStream << std::endl;
		}

		this->renderStream << renderStream.str();
	}

	void clear() override {
		Screen::clear();
#ifdef __linux__ 
		// WARNING: the linux code here is not tested
		// CSI[2J clears screen, CSI[H moves the cursor to top-left corner
		std::cout << "\x1B[2J\x1B[H";
#elif _WIN32
		COORD tl = { 0,0 };
		CONSOLE_SCREEN_BUFFER_INFO s;
		HANDLE console = GetStdHandle(STD_OUTPUT_HANDLE);
		GetConsoleScreenBufferInfo(console, &s);
		DWORD written, cells = s.dwSize.X * s.dwSize.Y;
		FillConsoleOutputCharacter(console, ' ', cells, tl, &written);
		FillConsoleOutputAttribute(console, s.wAttributes, cells, tl, &written);
		SetConsoleCursorPosition(console, tl);
#endif
	}
};

#endif // !CONSOLE_SCREEN_H

