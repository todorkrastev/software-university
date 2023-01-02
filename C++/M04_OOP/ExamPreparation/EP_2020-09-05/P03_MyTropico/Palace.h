#pragma once

#include <iostream>

#include "Building.h"

class Palace : public Building {
private:
	void print();

public:
	Palace() = delete;

	Palace(int width, int length);

	virtual ~Palace();

};

