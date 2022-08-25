#ifndef SPLIT_H
#define SPLIT_H

#include <vector>
#include <string>
#include <sstream>

template<typename T>
T parse(std::string s) {
	std::istringstream sIn(s);
	T t;
	sIn >> t;

	return t;
}

template<typename T>
std::vector<T> split(std::string s, char separator) {
	std::istringstream sIn(s);
	std::string itemStr;

	std::vector<T> items;
	while (std::getline(sIn, itemStr, separator)) {
		items.push_back(parse<T>(itemStr));
	}

	return items;
}

#endif // !SPLIT_H

