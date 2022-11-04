#ifndef DIGITS_FILTER_H
#define DIGITS_FILTER_H

#include "CharSequenceFilter.h"

class DigitsFilter : public CharSequenceFilter {
public:
	DigitsFilter() : CharSequenceFilter('0', '9') {}
};

#endif // !DIGITS_FILTER_H

