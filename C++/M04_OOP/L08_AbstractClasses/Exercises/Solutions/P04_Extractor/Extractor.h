#ifndef EXTRACTOR_H
#define EXTRACTOR_H

#include <string>
#include <istream>
#include <vector>

class Extractor {
private:
	std::istream& stream;
protected:
	virtual bool process(char symbol, std::string& output) = 0;
public:
	Extractor(std::istream& stream) : stream(stream) {}

	std::vector<std::string> extractAll() {
		std::vector<std::string> items;

		char currentSymbol;
		while (this->stream >> currentSymbol) {
			std::string item;
			if (this->process(currentSymbol, item)) {
				items.push_back(item);
			}
		}

		std::string item;
		if (this->process(0, item)) {
			items.push_back(item);
		}

		return items;
	}

	virtual ~Extractor() {}
};

#endif // !EXTRACTOR_H

