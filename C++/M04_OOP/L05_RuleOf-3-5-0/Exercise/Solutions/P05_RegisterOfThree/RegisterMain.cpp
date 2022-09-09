#include <iostream>
#include <string>
#include <cstdlib>
#include <sstream>

#include "Company.h"
#include "Register.h"

std::istream& operator>>(std::istream& in, Company& company) {
	return in >> company.id >> company.name;
}

std::ostream& operator<<(std::ostream& out, const Company& company) {
	return out << company.id << " " << company.name;
}

std::istream& operator>>(std::istream& in, Register& reg) {
	size_t numCompanies;
	in >> numCompanies;

	Register readRegister(numCompanies);

	for (size_t i = 0; i < numCompanies; i++) {
		Company c;
		in >> c;

		readRegister.add(c);
	}

	reg = readRegister;

	return in;
}

Company doRun(std::string inputStr) {
	std::istringstream input(inputStr);

	Register companyRegister;
	input >> companyRegister;

	int id;
	input >> id;

	return companyRegister.get(id);
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