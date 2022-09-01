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
		std::istringstream input(inputStr);

		size_t numCompanies;

		input >> numCompanies;

		Register companyRegister(numCompanies);

		for (size_t i = 0; i < numCompanies; i++) {
			Company c;
			input >> c;

			companyRegister.add(c);
		}

		int id;
		input >> id;

		Company newResult = companyRegister.get(id);
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