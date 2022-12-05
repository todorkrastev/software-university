#include <iostream>
#include <string>
#include <sstream>

#include "AnimalCharacteristics.h"
#include "AnimalTypes.h"

int main()
{
	int lines = 0;
	std::string input;
	std::istringstream istr;

	AnimalCharacteristics characteristics;
	AnimalTypes type;

	std::cin >> lines;
	std::cin.ignore();

	for (int i = 0; i < lines; ++i)
	{
		getline(std::cin, input);

		istr.clear();
		istr.str(input);

		istr >> characteristics.breed >> characteristics.name >> characteristics.category >> characteristics.age;
		type << characteristics;
	}

	type.print();

	return 0;
}
