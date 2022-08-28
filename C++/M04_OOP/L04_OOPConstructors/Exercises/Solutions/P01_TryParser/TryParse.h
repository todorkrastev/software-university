#ifndef TRY_PARSE

#include <string>
#include <sstream>

bool tryParse(std::string s, int& result) {
	std::istringstream sIn(s);

	int parsed;
	bool parseSuccess = (bool)(sIn >> parsed);

	result = parsed;

	return parseSuccess;
}

#endif // TRY_PARSE