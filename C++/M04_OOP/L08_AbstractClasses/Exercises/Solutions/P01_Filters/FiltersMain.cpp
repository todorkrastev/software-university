#include <iostream>
#include <string>
#include <vector>

#include "Filter.h"
#include "FilterFactory.h"

int main() {
	std::string input;
	std::getline(std::cin, input);

	const FilterFactory factory;

	std::string filterDefinition;
	std::getline(std::cin, filterDefinition);

	Filter* filter = factory.buildFilter(filterDefinition);

	filter->append(input);

	std::cout << filter->extract() << std::endl;

	delete filter;

	return 0;
}