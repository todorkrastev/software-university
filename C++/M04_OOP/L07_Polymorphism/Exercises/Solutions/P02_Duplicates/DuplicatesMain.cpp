#include <iostream>
#include <string>
#include <sstream>
#include <list>

#include "Company.h"

#include "RemoveDuplicates.h"

int main() {

	std::cin.sync_with_stdio(false);
	std::cout.sync_with_stdio(false);

	std::list<Company*> companies;
	std::string line;
	Company* lastCompany = nullptr;
	while (std::getline(std::cin, line) && line != "end") {
		if (line[0] != '*') {
			lastCompany = new Company();
			std::istringstream(line) >> *lastCompany;
			companies.push_back(lastCompany);
		} else {
			if (lastCompany == nullptr) {
				throw std::exception(); // error in parsing - tests or skeleton is wrong
			}

			if (line == "*begin") {
				companies.insert(companies.begin(), lastCompany);
			} else if (line == "*end") {
				companies.insert(companies.end(), lastCompany);
			} else {
				throw std::exception(); // error in parsing - tests or skeleton is wrong
			}
		}
	}

	removeDuplicates(companies);

	for (Company* companyPtr : companies) {
		std::cout << *companyPtr << std::endl;
	}
}