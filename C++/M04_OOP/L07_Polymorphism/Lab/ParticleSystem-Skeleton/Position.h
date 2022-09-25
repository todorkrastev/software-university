#ifndef POSITION_H
#define POSITION_H

struct Position {
	int row;
	int col;

	Position() {}

	Position(int row, int col) : row(row), col(col) {}

	Position nextRow() const {
		return Position(row + 1, col);
	}

	Position prevRow() const {
		return Position(row - 1, col);
	}

	Position nextCol() const {
		return Position(row, col + 1);
	}

	Position prevCol() const {
		return Position(row, col - 1);
	}
};


#endif // !POSITION_H

