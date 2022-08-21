#include <iostream>
#include <string>
#include <vector>
#include <sstream>

#include "Company.h"

#include "CompanyMemoryUtils.h"

int main() {
	typedef unsigned char byte;

	std::ostringstream input;
	std::string line;
	int numCompanies = 0;
	while (std::getline(std::cin, line) && line != "end") {
		input << line << " ";
		numCompanies++;
	}

	std::vector<byte> inputBytes;
	std::istringstream inputIn(input.str());
	int byteValue;
	while (inputIn >> byteValue) {
		inputBytes.push_back(byteValue);
	}

	byte* memory = new byte[inputBytes.size()];

	for (int i = 0; i < inputBytes.size(); i++) {
		memory[i] = inputBytes[i];
	}

	std::vector<Company> companies = readCompaniesFromMemory(memory, numCompanies);

	for (Company c : companies) {
		std::cout << c << std::endl;
	}

	delete[] memory;

	return 0;
}