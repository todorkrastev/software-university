#ifndef CONSOLE_UTILS_H
#define CONSOLE_UTILS_H

#ifdef __linux__ 
#include<iostream>
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

#endif // !CONSOLE_UTILS_H