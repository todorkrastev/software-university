#include <iostream>
#include <string>
#include <sstream>
#include <vector>

#include "Company.h"

#include "Find.h"

int main() {

	std::vector<Company*> companies;

	std::string line;
	while (std::getline(std::cin, line) && line != "end") {
		std::istringstream lineIn(line);

		Company* c = new Company();
		lineIn >> *c;
		companies.push_back(c);
	}

	std::string searchIdLine;
	std::getline(std::cin, searchIdLine);
	int searchId = stoi(searchIdLine);

	Company* companyWithSearchedId = find(companies, searchId);

	if (companyWithSearchedId != nullptr) {
		std::cout << *companyWithSearchedId << std::endl;
	} else {
		std::cout << "[not found]" << std::endl;
	}

	for (auto companyPtr : companies) {
		delete companyPtr;
	}

	return 0;
}