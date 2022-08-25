#include <iostream>
#include <string>
#include <sstream>
#include <set>

#include "Article13Filter.h"

int main() {
	std::string copyrightedLine;
	std::getline(std::cin, copyrightedLine);

	std::set<std::string> copyrighted;
	std::istringstream lineIn(copyrightedLine);
	std::string copyrightedItem;
	while (lineIn >> copyrightedItem) {
		copyrighted.insert(copyrightedItem);
	}

	Article13Filter filter(copyrighted);

	std::string inputLine;
	while (std::getline(std::cin, inputLine) && inputLine != "end") {
		if (!filter.blockIfCopyrighted(inputLine)) {
			std::cout << inputLine << std::endl;
		}
	}

	std::cout << "Blocked: ";
	for (std::string blockedItem : filter.getBlocked()) {
		std::cout << blockedItem << " ";
	}

	return 0;
}
