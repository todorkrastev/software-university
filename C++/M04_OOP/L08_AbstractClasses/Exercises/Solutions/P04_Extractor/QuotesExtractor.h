#ifndef QUOTES_EXTRACTOR_H
#define QUOTES_EXTRACTOR_H

#include "BufferedExtractor.h"

class QuotesExtractor : public BufferedExtractor {
	bool inQuotes;
protected:
	bool shouldBuffer(char symbol) override {
		if (inQuotes) {
			this->inQuotes = (symbol != '"');
			return this->inQuotes;
		} else {
			this->inQuotes = symbol == '"';
			return false;
		}
	}
public:
	QuotesExtractor(std::istream& stream) : BufferedExtractor(stream), inQuotes(false) {}
};

#endif // !QUOTES_EXTRACTOR_H

