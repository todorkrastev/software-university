#ifndef PROFIT_REPORT_H
#define PROFIT_REPORT_H

#include <map>
#include <vector>
#include <string>
#include <sstream>

#include "Company.h"
#include "ProfitCalculator.h"

std::string getProfitReport(const Company* fromInclusive, const Company* toInclusive, const std::map<int, ProfitCalculator>& profitCalculatorsByCompany) {
	std::ostringstream report;

	for (const Company* c = fromInclusive; c <= toInclusive; c++) {
		int id = c->getId();
		ProfitCalculator calculator = profitCalculatorsByCompany.find(id)->second;
		report << c->getName() << " = " << calculator.calculateProfit(*c);

		if (c != toInclusive) {
			report << std::endl;
		}
	}

	return report.str();
}

#endif // !PROFIT_REPORT_H

