#ifndef CPP_ADVANCED_COMPANYMEMORYUTILS_H
#define CPP_ADVANCED_COMPANYMEMORYUTILS_H

#include <vector>
#include <sstream>
#include "Company.h"

typedef unsigned char byte;

namespace local {
	byte next(const byte*& memory) {
		return *(memory++);
	}

	int parseId(const byte*& memory) {
		return next(memory);
	}

	std::string parseName(const byte*& memory) {
		std::ostringstream oss;
		do {
			oss << next(memory);
		} while (*memory != 0);
		memory++; // move pointer past '\0'
		return oss.str();
	}

	std::vector<std::pair<char, char> > parseEmployees(const byte*& memory) {
		std::vector<std::pair<char, char> > employees;
		const int employees_count = next(memory);
		for (int j = 0; j < employees_count; ++j) {
			const auto first_name_start_char = next(memory);
			const auto last_name_start_char = next(memory);
			employees.emplace_back(first_name_start_char, last_name_start_char);
		}
		return employees;
	}

	Company parseCompany(const byte*& memory) {
		const auto id = parseId(memory);
		const auto name = parseName(memory);
		const auto employees = parseEmployees(memory);
		return Company(id, name, employees);
	}
}

std::vector<Company> readCompaniesFromMemory(const byte* memory, const int& companies_count) {
	std::vector<Company> companies;
	for (int i = 0; i < companies_count; ++i) {
		companies.push_back(local::parseCompany(memory));
	}
	return companies;
}

/*std::vector<Company> readCompaniesFromMemory(const byte* memory, const int& numCompanies)
{
  auto companies = new std::vector<Company>;
  for (int i = 0; i < numCompanies; ++i) {
	int id = *memory++;
	std::ostringstream oss;
	do {
	  oss << *memory++;
	} while (*memory != 0);
	memory++;
	std::string name = oss.str();
	int empl_count = *memory++;
	std::vector<std::pair<char, char> > employees;
	for (int j = 0; j < empl_count; ++j) {
	  byte first_name = *memory++;
	  byte last_name = *memory++;
	  employees.emplace_back(first_name, last_name);
	}
	Company company = Company(id, name, employees);
	companies->push_back(company);
  }
  return *companies;
}*/
#endif //CPP_ADVANCED_COMPANYMEMORYUTILS_H
