#ifndef FIND_H
#define FIND_H

#include <vector>
#include "Company.h"

Company* find(std::vector<Company*> companies, int id) {
	for (Company* companyPtr : companies) {
		if (companyPtr->getId() == id) {
			return companyPtr;
		}
	}

	return nullptr;
}

#endif // !FIND_H

