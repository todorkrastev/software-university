#ifndef DIGITS_EXTRACTOR_H
#define DIGITS_EXTRACTOR_H

#include <cctype>

#include "Extractor.h"

class DigitsExtractor : public Extractor {
protected:
	bool process(char symbol, std::string& output) override {
		if (isdigit(symbol)) {
			output = symbol;
			return true;
		} else {
			return false;
		}
	}
public:
	DigitsExtractor(std::istream& stream) : Extractor(stream) {}
};

#endif // !DIGITS_EXTRACTOR_H

