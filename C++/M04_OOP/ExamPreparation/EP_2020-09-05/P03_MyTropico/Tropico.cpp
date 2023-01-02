#include "Tropico.h"

void Tropico::build(const std::string& type, int width, int length) {
	if (type == "Palace") {
		buildings.push_back(std::make_shared<Palace>(width, length));
	}
	else if (type == "House") {
		buildings.push_back(std::make_shared<House>(width, length));
	}
}

void Tropico::duplicate(int firstIndex, int secondIndex) {
	if (firstIndex == secondIndex) {
		std::cout << "Invalid operation" << std::endl;
	}
	else {
		this->buildings[firstIndex] = this->buildings[secondIndex];
	}
}

void Tropico::replace(int firstIndex, int secondIndex) {
	if (firstIndex == secondIndex
		|| (firstIndex < 0 || firstIndex >= this->buildings.size())
		|| (secondIndex < 0 || secondIndex >= this->buildings.size())) {
		std::cout << "Invalid operation" << std::endl;
	}
	else {
		std::swap(this->buildings[firstIndex], this->buildings[secondIndex]);
	}
}

void Tropico::demolish(int index) {
	this->buildings.erase(this->buildings.begin() + index);
}
