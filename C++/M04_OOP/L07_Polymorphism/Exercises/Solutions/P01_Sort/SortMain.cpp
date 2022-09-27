#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <algorithm>

#include "Company.h"

int main() {

	std::vector<Company> companies;
	std::string line;
	while (std::getline(std::cin, line) && line != "end") {
		std::istringstream lineIn(line);

		std::string name;
		int id;
		lineIn >> name >> id ;
		companies.push_back(Company{id, name});
	}

	std::string sortBy;
	std::cin >> sortBy;

	bool(*lessThan)(const Company&, const Company&) = nullptr;
	if (sortBy == "name") {
		lessThan = [](const Company& a, const Company& b) {
			return a.getName() < b.getName();
		};
	} else if (sortBy == "id") {
		lessThan = [](const Company& a, const Company& b) {
			return a.getId() < b.getId();
		};
	}

	sort(companies.begin(), companies.end(), lessThan);

	for (Company c : companies) {
		std::cout << c.toString() << std::endl;
	}

	return 0;
}