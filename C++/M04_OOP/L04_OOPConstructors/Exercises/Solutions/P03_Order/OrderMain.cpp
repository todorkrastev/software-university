#include <iostream>
#include <string>
#include <sstream>
#include <vector>

#include "Company.h"

#include "OrderedInserter.h"

int main() {

	std::vector<const Company*> companies;

	OrderedInserter inserter{ companies };

	std::string line;
	while (std::getline(std::cin, line) && line != "end") {
		std::istringstream lineIn(line);

		Company* c = new Company();
		lineIn >> *c;
		inserter.insert((const Company*)c);
	}

	for (auto companyPtr : companies) {
		std::cout << *companyPtr << std::endl;
		delete companyPtr;
	}

	return 0;
}