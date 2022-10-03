#include <iostream>
#include <string>
#include <memory>
#include <sstream>

#include "Aggregator.h"
#include "SumAggregator.h"
#include "AverageAggregator.h"
#include "MinAggregator.h"

int main() {
	std::string aggregationType;
	std::cin >> aggregationType;
	std::cin.ignore();

	std::string valuesLine;
	std::getline(std::cin, valuesLine);
	std::istringstream valuesIn(valuesLine);

	StreamAggregator* aggregator;

	if (aggregationType == "sum") {
		aggregator = new SumAggregator(valuesIn);
	} else if (aggregationType == "average") {
		aggregator = new AverageAggregator(valuesIn);
	} else if (aggregationType == "min") {
		aggregator = new MinAggregator(valuesIn);
	} else {
		throw std::exception();
	}

	std::cout << aggregator->aggregate() << std::endl;

	delete aggregator;

	return 0;
}