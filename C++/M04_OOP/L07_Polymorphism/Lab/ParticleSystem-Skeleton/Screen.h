#ifndef SCREEN_H
#define SCREEN_H

#include <vector>

template<typename Pixel>
class Screen {
protected:
	const int rows, cols;

	std::vector<std::vector<Pixel> > renderMatrix;

	const Pixel background;
public:
	Screen(int rows, int cols, Pixel background)
		: rows(rows), cols(cols), background(background) {
		for (int r = 0; r < rows; r++) {
			std::vector<Pixel> renderRow;
			for (int c = 0; c < cols; c++) {
				renderRow.push_back(background);
			}

			this->renderMatrix.push_back(renderRow);
		}
	}

	void set(int row, int col, Pixel pixel) {
		if (row < 0 || col < 0 || row >= this->rows || col >= this->cols) {
			return;
		}

		this->renderMatrix[row][col] = pixel;
	}

	virtual void render() {
	}

	virtual void clear() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				this->renderMatrix[r][c] = this->background;
			}
		}
	}
};

#endif // !SCREEN_H