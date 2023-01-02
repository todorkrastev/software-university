#include <iostream>
#include <sstream>
#include <string>

#include "Discovery.h"
#include "ScientificField.h"

int main()
{
	int lineCount = 0;
	std::string input;
	std::istringstream istr;

	Discovery discoveryInfo;

	ScientificField scienceField;

	std::cin >> lineCount;
	std::cin.ignore();

	for (int i = 0; i < lineCount; ++i)	{
		
		getline(std::cin, input);
		istr.clear();
		istr.str(input);

		istr >> discoveryInfo.name >> discoveryInfo.year >> discoveryInfo.scientistName >> discoveryInfo.fieldType;
		scienceField << discoveryInfo;
	}
	scienceField.print();

	return 0;
}

