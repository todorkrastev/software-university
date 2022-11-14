#ifndef EXTRACTOR_INITIALIZATION_H

#include <string>
#include <vector>
#include <memory>

#include "Extractor.h"

#include "DigitsExtractor.h"
#include "NumbersExtractor.h"
#include "QuotesExtractor.h"

std::shared_ptr<Extractor> getExtractor(const std::string& extractType, std::istream& stream) {
	if (extractType == "digits") {
		return std::make_shared<DigitsExtractor>(stream);
	} else if (extractType == "numbers") {
		return std::make_shared<NumbersExtractor>(stream);
	} else if (extractType == "quotes") {
		return std::make_shared<QuotesExtractor>(stream);
	}

	return nullptr;
}

#endif // !EXTRACTOR_INITIALIZATION_H

