#include <iostream>
#include <string>

#include <map>

#include "Company.h"

int main() {
	std::map<int, HasInfo*> byId;

	std::string line;
	while (std::getline(std::cin, line) && line != "end") {
		std::istringstream lineIn(line);
	
		Company* c = new Company();	
		lineIn >> *c;
		
		HasId* hasId = c;
		byId[hasId->getId()] = c;
	}

	for (auto entry : byId) {
		std::cout << entry.second->getInfo() << std::endl;
		delete entry.second;
	}

	return 0;
}