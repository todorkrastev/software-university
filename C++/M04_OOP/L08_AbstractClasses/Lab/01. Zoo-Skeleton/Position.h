#ifndef POSITION_H
#define POSITION_H

class Position {
private:
	static int MinPosition;
	static int MaxPosition;

	static int normalize(int rowOrCol) {
		if (rowOrCol < MinPosition) {
			return MinPosition;
		}

		if (rowOrCol > MaxPosition) {
			return MaxPosition;
		}

		return rowOrCol;
	}

	int row;
	int col;
public:
	Position(int row, int col) : row(normalize(row)), col(normalize(col)) {}

	int getRow() const {
		return this->row;
	}

	int getCol() const {
		return this->col;
	}

	Position operator+(const Position& other) const {
		Position sum = *this;
		return sum += other;
	}

	Position& operator+=(const Position& other) {
		this->row = normalize(this->row + other.row);
		this->col = normalize(this->col + other.col);
		return *this;
	}
};

#endif // !POSITION_H

