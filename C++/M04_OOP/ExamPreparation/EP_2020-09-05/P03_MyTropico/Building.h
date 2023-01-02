#pragma once

class Building {
private:
	int width;
	int length;

	virtual void print() = 0;

protected:

	int getWidth() const;

	int getLength() const;

public:
	Building() = delete;
	Building(int width, int length);
	virtual ~Building() = default;

	Building(const Building& other) = default;
	Building& operator=(const Building& other) = default;
};

