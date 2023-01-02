#pragma once

#include <vector>
#include <string>
#include <memory>
#include <typeinfo>

#include "Palace.h"
#include "House.h"

#include "Building.h"

class Tropico {
private:
	std::vector<std::shared_ptr<Building>> buildings;

public:
	Tropico() = default;
	~Tropico() = default;

	void build(const std::string& type, int width, int length);

	void duplicate(int firstIndex, int secondIndex);

	void replace(int firstIndex, int secondIndex);

	void demolish(int index);
};

