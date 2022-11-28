#ifndef RENDERING_UTILS_H
#define RENDERING_UTILS_H

#include <string>
#include <sstream>
#include <iostream>
#include <vector>

#include "ConsoleUtils.h"
#include "Position.h"

class Renderer {
public:
private:
	const int size;
	std::vector<std::vector<char> > renderBuffer;
public:
	Renderer(int size) : size(size) {
		for (int r = 0; r < size; r++) {
			std::vector<char> bufferRow;
			for (int c = 0; c < size; c++) {
				bufferRow.push_back(' ');
			}
			renderBuffer.push_back(bufferRow);
		}
	}

	void render(Position p, std::string image) {
		for (int i = 0; i < image.size() && p.getCol() + i < size; i++) {
			renderBuffer[p.getRow()][p.getCol() + i] = image[i];
		}
	}

	void flushToScreen() {
		std::ostringstream output;
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				output << this->renderBuffer[r][c];
				this->renderBuffer[r][c] = ' ';
			}
			output << std::endl;
		}

		clearScreen();
		std::cout << output.str() << std::endl;
	}
};

#endif // !RENDERING_UTILS_H
