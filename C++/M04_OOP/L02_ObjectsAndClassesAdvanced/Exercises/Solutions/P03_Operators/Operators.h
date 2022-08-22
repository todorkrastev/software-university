#ifndef OPERATORS_H
#define OPERATORS_H

#include <ostream>
#include <vector>
#include <string>
#include <sstream>

std::ostream& operator<<(std::ostream& out, const std::vector<std::string>& v) {
	for (std::string s : v) {
		out << s << std::endl;
	}
	return out;
}

std::vector<std::string>& operator<<(std::vector<std::string>& v, const std::string& s) {
	v.push_back(s);
	return v;
 }

std::string operator+(std::string s, int i) {
	std::ostringstream result;

	result << s << i;

	return result.str();
}

#endif // !OPERATORS_H