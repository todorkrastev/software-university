#ifndef NON_CAPITALS_FILTER_H
#define NON_CAPITALS_FILTER_H

#include "CharSequenceFilter.h"

class NonCapitalsFilter : public CharSequenceFilter {
public:
	NonCapitalsFilter() : CharSequenceFilter('a', 'z') {}
};

#endif // !NON_CAPITALS_FILTER_H

