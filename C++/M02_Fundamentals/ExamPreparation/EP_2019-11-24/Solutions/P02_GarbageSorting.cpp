#include <iostream>
#include <vector>
#include <map>
#include <set>

int main() {
	const std::set<std::string> garbageTypes{ "glass", "metal", "plastic" };

	int garbageItems;
	std::cin >> garbageItems;

	std::map<std::string, std::vector<size_t>> linesIds{ };

	size_t lastId = 0;
	while (garbageItems-- > 0) {
		std::string type, order;
		std::cin >> type >> order;

		if (garbageTypes.find(type) == garbageTypes.cend()) {
			continue;
		}

		if (order == "front") {
			linesIds[type].insert(linesIds[type].begin(), ++lastId);
		} else if (order == "back") {
			linesIds[type].emplace_back(++lastId);
		}
	}

	for (const auto& pair : linesIds) {
		std::cout << pair.first << " -";
		for (auto id : pair.second) {
			std::cout << " " << id;
		}
		std::cout << std::endl;
	}

	return 0;
}