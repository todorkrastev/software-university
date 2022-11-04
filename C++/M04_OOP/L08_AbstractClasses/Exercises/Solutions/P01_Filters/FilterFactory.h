#ifndef FILTER_FACTORY_H
#define FILTER_FACTORY_H

#include <string>

#include "Filter.h"
#include "DigitsFilter.h"
#include "CapitalsFilter.h"
#include "NonCapitalsFilter.h"

class FilterFactory {
public:
	Filter* buildFilter(std::string filterDefinition) const {
		if (filterDefinition == "A-Z") {
			return new CapitalsFilter();
		}
		if (filterDefinition == "a-z") {
			return new NonCapitalsFilter();
		} else if (filterDefinition == "0-9") {
			return new DigitsFilter();
		} else {
			return nullptr;
		}
	}
};

#endif
