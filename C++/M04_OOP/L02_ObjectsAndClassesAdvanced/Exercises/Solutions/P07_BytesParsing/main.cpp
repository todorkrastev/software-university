#include <iostream>
#include <string>
#include <vector>
#include "Defines.h"

ErrorCode parseData(const std::string& commands,
	const char* rawDataBytes,
	const size_t rawDatytesCount,
	std::vector<long long>& outParsedNumbers);

void printResult(const ErrorCode errorCode,
	const std::vector<long long>& parsedNumbers);

int main() {
	std::string commands;
	std::string rawDataInput;
	std::vector<long long> parsedNumbers;

	getline(std::cin, commands);
	getline(std::cin, rawDataInput);

	//Transforming ASCII values to integer values
	for (size_t i = 0; i < rawDataInput.size(); ++i) {
		rawDataInput[i] -= '0';
	}

	const ErrorCode errorCode = parseData(commands,
		rawDataInput.c_str(),
		rawDataInput.size(),
		parsedNumbers);

	printResult(errorCode, parsedNumbers);

	return 0;
}