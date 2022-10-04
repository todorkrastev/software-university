#include <iostream>
#include <memory>

#include <string>
#include <sstream>

#include "TypedStream.h"
#include "IntStream.h"
#include "StringStream.h"
#include "VectorStream.h"

template<typename T>
std::ostream& operator<<(std::ostream& out, const std::vector<T>& v) {
	for (T item : v) {
		out << item << " ";
	}

	return out;
}

template<>
std::ostream& operator<<(std::ostream& out, const std::vector<Vector2D>& v) {
	for (auto item : v) {
		out << (std::string)item << " ";
	}

	return out;
}

int main() {
	std::ostringstream lines;
	std::string line;
	while (std::getline(std::cin, line) && line != "end") {
		lines << line << std::endl;
	}

	std::string inputType;
	std::cin >> inputType;

	if (inputType == "int") {
		IntStream stream(lines.str());
		std::cout << stream.readToEnd() << std::endl;
	} else if (inputType == "string") {
		StringStream stream(lines.str());
		std::cout << stream.readToEnd() << std::endl;
	} else if (inputType == "vector") {
		VectorStream stream(lines.str());
		std::cout << stream.readToEnd() << std::endl;
	} else {
		throw std::exception();
	}

	return 0;
}