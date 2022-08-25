#ifndef PARSER_H
#define PARSER_H

#include <string>
#include <sstream>
#include <istream>

template<typename T>
class Parser {
	std::istream& in;
	std::string stopLine;
public:
	Parser(std::istream& in, std::string stopLine) 
		: in(in), stopLine(stopLine) {}

	bool readNext(T& next) {
		std::string line;
		std::getline(this->in, line);

		if (line != this->stopLine) {
			std::istringstream lineIn(line);
			lineIn >> next;
			return true;
		} else {
			return false;
		}
	}
};

#endif // !PARSER_H

