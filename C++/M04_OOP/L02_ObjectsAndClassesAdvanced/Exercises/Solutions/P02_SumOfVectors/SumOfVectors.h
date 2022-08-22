#ifndef SUM_OF_VECTORS_H
#define SUM_OF_VECTORS_H
#include <iostream>
#include <string>
#include <vector>

const std::vector<std::string> operator+(const std::vector<std::string>& vec1, const std::vector<std::string>& vec2) {
	std::vector<std::string> vecToReturn;

	for (int i = 0; i < vec1.size(); i++) {
		std::string numberToPush = vec1[i] + " " + vec2[i];

		vecToReturn.push_back(numberToPush);
	}

	return vecToReturn;
}

#endif // SUM_OF_VECTORS