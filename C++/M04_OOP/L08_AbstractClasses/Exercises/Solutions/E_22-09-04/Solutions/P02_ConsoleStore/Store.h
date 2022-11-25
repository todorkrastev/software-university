#ifndef STORE_H_
#define STORE_H_

#include "Defines.h"
#include "BaseConsole.h"

#include <unordered_map>
#include <memory>
#include<vector>

class Store {

public:
	Store() = default;

	void addPs(int price, int quality, int generation);

	void addXbox(int price, int quality);

	void remove(ConsoleType type);

	void sortByPrice(ConsoleType type);

	void sortByQuality(ConsoleType type);

	void print(ConsoleType pointer);

private:
	void addConsole(std::unique_ptr<BaseConsole> pointer);

	std::unordered_map<ConsoleType, std::vector<std::unique_ptr<BaseConsole>>> _store{};
};

#endif /* STORE_H_ */ 
