#ifndef NUMBERS_EXTRACTOR_H
#define NUMBERS_EXTRACTOR_H

#include <cctype>

#include "BufferedExtractor.h"

class NumbersExtractor : public BufferedExtractor {
	bool inNumber;
protected:
	bool shouldBuffer(char symbol) override {
		return inNumber = isdigit(symbol);
	}
public:
	NumbersExtractor(std::istream& stream) : BufferedExtractor(stream), inNumber(false) {}
};

#endif // !NUMBERS_EXTRACTOR_H

