#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <map>

#include "Company.h"
#include "ProfitCalculator.h"

#include "ProfitReport.h"

int main() {

	std::vector<Company> companies;

	std::string line;
	while (std::getline(std::cin, line) && line != "end") {
		std::istringstream lineIn(line);

		Company c;
		lineIn >> c;
		companies.push_back(c);
	}

	std::map<int, ProfitCalculator> profitCalculatorsByCompany;
	line = "";
	while (std::getline(std::cin, line) && line != "end") {
		std::istringstream lineIn(line);

		int companyId;
		lineIn >> companyId;
		ProfitCalculator calculator;
		lineIn >> calculator;

		profitCalculatorsByCompany[companyId] = calculator;
	}

	Company* fromInclusive = &companies[0];
	Company* toInclusive = &companies[companies.size() - 1];

	std::cout << getProfitReport(fromInclusive, toInclusive, profitCalculatorsByCompany) << std::endl;

	return 0;
}