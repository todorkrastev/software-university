#include "Store.h"
#include "Ps.h"
#include "Xbox.h"

#include <algorithm>

std::string getName(ConsoleType type) {
	switch (type) {
	case ConsoleType::PS:
		return "PS";
	case ConsoleType::XBOX:
		return "Xbox";
	default:
		return "UNKNOWN";
	}
}

void Store::addPs(int price, int quality, int generation) {
	addConsole(std::unique_ptr<Ps>(new Ps(price, quality, generation)));
}

void Store::addXbox(int price, int quality) {
	addConsole(std::unique_ptr<Xbox>(new Xbox(price, quality)));
}

void Store::remove(ConsoleType type) {
	std::cout << "Removing: ";
	_store[type].back()->printToConsole();
	_store[type].pop_back();
}

void Store::sortByPrice(ConsoleType type) {
	std::cout << "Sorting all " << getName(type) << " by price" << std::endl;
	std::sort(_store[type].begin(),
		_store[type].end(),
		[](const std::unique_ptr<BaseConsole>& first, const std::unique_ptr<BaseConsole>& second) {
			return first->getPrice() > second->getPrice();
		});
}

void Store::sortByQuality(ConsoleType type) {
	std::cout << "Sorting all " << getName(type) << " by quality" << std::endl;
	std::sort(_store[type].begin(), _store[type].end(),
		[](const std::unique_ptr<BaseConsole>& first, const std::unique_ptr<BaseConsole>& second) {
			return first->getQuality() > second->getQuality();
		});
}

void Store::print(ConsoleType type) {
	std::cout << "Printing all " << getName(type) << " data" << std::endl;
	std::for_each(_store[type].cbegin(),
		_store[type].cend(),
		[](const std::unique_ptr<BaseConsole>& pointer) {
			pointer->printToConsole();
		});
}

void Store::addConsole(std::unique_ptr<BaseConsole> pointer) {
	std::cout << "Adding: ";
	pointer->printToConsole();
	_store[pointer->getType()].push_back(std::move(pointer));
}