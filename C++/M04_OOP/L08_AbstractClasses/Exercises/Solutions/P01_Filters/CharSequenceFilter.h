#ifndef CHAR_SEQUENCE_FILTER_H
#define CHAR_SEQUENCE_FILTER_H

#include "Filter.h"

class CharSequenceFilter : public Filter {
	char fromChar;
	char toChar;
public:
	CharSequenceFilter(char fromChar, char toChar) : fromChar(fromChar), toChar(toChar) {}

	bool shouldFilterOut(char symbol) const override {
		return this->fromChar <= symbol && symbol <= this->toChar;
	}
};

#endif // !CHAR_SEQUENCE_FILTER_H

