#include <iostream>
#include <string>
#include <cstdlib>
#include <sstream>

#include "Company.h"
#include "ArrayOfPointers.h"

std::istream& operator>>(std::istream& in, Company& company) {
	return in >> company.id >> company.name;
}

std::ostream& operator<<(std::ostream& out, const Company& company) {
	return out << company.id << " " << company.name;
}

Company doRun(std::string inputStr) {
	std::istringstream in(inputStr);

	size_t numCompanies;
	in >> numCompanies;

	ArrayOfPointers companies;

	for (size_t i = 0; i < numCompanies; i++) {
		Company* c = new Company();
		in >> *c;

		companies.add(c);
	}

	int id;
	in >> id;

	Company result;
	for (size_t i = 0; i < companies.getSize(); i++) {
		if (companies.get(i)->getId() == id) {
			result = *companies.get(i);
		}
	}

	return result;
}

int main() {
	size_t numRuns;
	std::cin >> numRuns;

	std::string line;
	std::ostringstream inputBuffer;

	Company result;

	while (std::getline(std::cin, line) && line != "end") {
		inputBuffer << line << std::endl;
	}

	std::string inputStr = inputBuffer.str();

	for (size_t run = 0; run < numRuns; run++) {
		Company newResult = doRun(inputStr);
		if (run > 0) {
			if (result.getId() != newResult.getId() || result.getName() != newResult.getName()) {
				std::cout << "wrong result on run " + run << std::endl;
			}
		}

		result = newResult;
	}

	std::cout << result << std::endl;

	return 0;
}