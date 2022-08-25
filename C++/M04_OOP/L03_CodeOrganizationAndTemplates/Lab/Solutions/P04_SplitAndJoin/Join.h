#ifndef JOIN_H
#define JOIN_H

#include <string>
#include <vector>
#include <sstream>

template<typename T>
std::string join(std::vector<T> items, std::string joinStr) {
	std::ostringstream out;
	for (size_t i = 0; i < items.size(); i++) {
		out << items[i];
		if (i < items.size() - 1) {
			out << joinStr;
		}
	}

	return out.str();
}

#endif // !JOIN_H

