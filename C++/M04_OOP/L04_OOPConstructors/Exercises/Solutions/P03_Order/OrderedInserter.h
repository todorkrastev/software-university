#ifndef ORDERED_INSERTER_H
#define ORDERED_INSERTER_H

#include "Company.h"

#include <vector>

class OrderedInserter {
	std::vector<const Company*>& v;
public:
	OrderedInserter(std::vector<const Company*>& v) : v(v) {}

	void insert(const Company* c) {
		auto insertIterator = v.begin();
		while (insertIterator != v.end() && c->getId() > (*insertIterator)->getId()) {
			insertIterator++;
		}

		v.insert(insertIterator, c);
	}
};


#endif // !ORDERED_INSERTER_H
