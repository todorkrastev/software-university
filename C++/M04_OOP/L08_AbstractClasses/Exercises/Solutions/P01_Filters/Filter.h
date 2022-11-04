#ifndef FILTER_H
#define FILTER_H

#include <string>
#include <sstream>

class Filter {
private:
	std::ostringstream filtered;
protected:
	virtual bool shouldFilterOut(char symbol) const = 0;
public:
	void append(std::string s) {
		for (char symbol : s) {
			if (!shouldFilterOut(symbol)) {
				filtered << symbol;
			}
		}
	}

	std::string extract() {
		std::string filteredStr = filtered.str();

		filtered.str("");
		filtered.clear();

		return filteredStr;
	}

	virtual ~Filter() {}
};

#endif // !FILTER_H

