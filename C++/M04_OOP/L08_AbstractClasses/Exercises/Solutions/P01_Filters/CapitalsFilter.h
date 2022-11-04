#ifndef CAPITALS_FILTER_H
#define CAPITALS_FILTER_H

#include "CharSequenceFilter.h"

class CapitalsFilter : public CharSequenceFilter {
public:
	CapitalsFilter() : CharSequenceFilter('A', 'Z') {}
};

#endif // !CAPITALS_FILTER_H

