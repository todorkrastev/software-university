#ifndef COMPANY_MEMORY_UTILS
#define COMPANY_MEMORY_UTILS

#include <vector>
#include <string>
#include <utility>
#include <sstream>
#include "Company.h"

typedef unsigned char byte;

typedef byte* bytePtr;

Company readCompany(const byte*& memory) {
	byte id;
	std::string name;
	std::vector<std::pair<char, char> > employees;

	// NOTE: moving the pointer (i.e. memory++) instead of using an index would be slightly more efficient (1 increment vs 1 increment + 1 calculation)
	int byteIndex = 0;

	id = memory[byteIndex];
	byteIndex++;

	// NOTE: this can also be done with the string constructor that accepts a null-terminated char*, then getting the size of that string + 1 will give us the next position

	std::ostringstream nameOut;
	while (memory[byteIndex] != '\0') {
		nameOut << memory[byteIndex];
		byteIndex++;
	}
	name = nameOut.str();
	byteIndex++; // moving after the null-terminator

	byte numEmployees = memory[byteIndex];
	byteIndex++;
	for (int i = 0; i < numEmployees; i++) {
		char firstInitial = memory[byteIndex];
		byteIndex++;
		char secondInitial = memory[byteIndex];
		byteIndex++;

		employees.push_back(std::make_pair(firstInitial, secondInitial));
	}

	// the company has been read and byteIndex is now after the last employee initial, set the memory pointer reference to that position
	memory = (memory + byteIndex);

	return Company(id, name, employees);
}

std::vector<Company> readCompaniesFromMemory(const byte* memory, int numCompanies) {
	std::vector<Company> companies;

	for (int i = 0; i < numCompanies; i++) {
		companies.push_back(readCompany(memory));
	}

	return companies;
}

#endif // !COMPANY_MEMORY_UTILS