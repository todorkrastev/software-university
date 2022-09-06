#ifndef MAKE_COMPANY_H
#define MAKE_COMPANY_H

/*
#include <memory>
#include <vector>
#include <string>

#include "Company.h"


std::shared_ptr<Company> makeCompany(const std::vector<std::string> & properties) {
	int id = std::stoi(properties[0]);
	std::string name = properties[1];
	std::vector<std::pair<char, char>> employees;

	for (size_t idx = 2; idx < properties.size(); idx++) {
		std::pair<char, char> thePair((char)(properties[idx][0]), (char)(properties[idx][1]));
		employees.push_back(thePair);
	}

	return std::shared_ptr<Company>(new Company(id, name, employees));
}
*/

#include <memory>
#include <vector>
#include <string>
#include <utility>
#include <cstddef>

#include "Company.h"

int toInt(const std::string& s) {
	int i;
	std::istringstream(s) >> i;
	return i;
}

std::shared_ptr<Company> makeCompany(std::vector<std::string> properties) {
	int id = toInt(properties[0]);
	std::string name = properties[1];

	std::vector<std::pair<char, char> > employeeInitials;
	for (size_t i = 2; i < properties.size(); i++) {
		std::string initialsPair = properties[i];
		employeeInitials.push_back(std::pair<char, char>{ initialsPair[0], initialsPair[1] });
	}

	return std::shared_ptr<Company>(new Company(id, name, employeeInitials));
}


#endif // !MAKE_COMPANY_H