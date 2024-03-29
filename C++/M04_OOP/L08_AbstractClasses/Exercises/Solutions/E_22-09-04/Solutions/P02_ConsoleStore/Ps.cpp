#include "Ps.h"

#include <string>

Ps::Ps(int price, int quality, int generation)
	: BaseConsole(price, quality),
	_generation(generation) {}

ConsoleType Ps::getType() const {
	return ConsoleType::PS;
}

std::string Ps::getDetailsPrefix() const {
	return "PS with generation " + std::to_string(_generation) + ',';
}