#ifndef REMOVE_DUPLICATES_H
#define REMOVE_DUPLICATES_H

#include <list>
#include <set>
#include <string>
#include <sstream>

#include "Company.h"

void removeDuplicates(std::list<Company*>& companies) {
	std::set<void*> uniquePointers;
	std::set<std::string> uniqueCompanyNames;

	auto i = companies.begin();
	while (i != companies.end()) {
		Company* ptr = *i;

		if (uniquePointers.find((void*)ptr) != uniquePointers.end()) {
			i = companies.erase(i);
		}
		else {
			if (uniqueCompanyNames.find(ptr->getName()) != uniqueCompanyNames.end()) {
				i = companies.erase(i);
			} else {
				i++;
				uniquePointers.insert(ptr);
				uniqueCompanyNames.insert(ptr->getName());
			}
		}
	}
}

#endif // !REMOVE_DUPLICATES_H

