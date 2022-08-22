#include "SumOfVectors.h"

#include <vector>
#include <string>
#include <iostream>

void PrintSum(const std::vector<std::string>& vecResult) {
	for (int i = 0; i < vecResult.size(); i++) {
		std::cout << vecResult[i] << std::endl;
	}
}


int main() {
	int nSizeOfVectors;
	std::cin >> nSizeOfVectors;

	std::vector<std::string>vec1;
	std::vector<std::string>vec2;

	for (int i = 0; i < nSizeOfVectors; i++) {
		std::string strToPush;
		std::cin >> strToPush;

		vec1.push_back(strToPush);
	}

	for (int i = 0; i < nSizeOfVectors; i++) {
		std::string strToPush;
		std::cin >> strToPush;

		vec2.push_back(strToPush);
	}

	std::vector<std::string>vec3 = vec1 + vec2;

	PrintSum(vec3);


	return 0;
}
