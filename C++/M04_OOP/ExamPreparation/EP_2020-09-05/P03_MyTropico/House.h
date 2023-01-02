#pragma once

#include <iostream>

#include "Building.h"

class House : public Building {
private:
	void print();

public:
	House() = delete;

	House(int width, int length);

	virtual ~House();

};

