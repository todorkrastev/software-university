#include <iostream>
#include <sstream>
#include <string>

#include "Struct.h"
#include "MagicKingdom.h"

int main()
{
	int lineCount = 0;
	std::string input;
	std::istringstream istr;

	Villager characteristics;

	MagicKingdom statistics; 

	std::cin >> lineCount;
	std::cin.ignore();

	for (int i = 0; i < lineCount; ++i)	{
		
		getline(std::cin, input);
		istr.clear();
		istr.str(input);

		istr >> characteristics.name >> characteristics.power >> characteristics.magicItem;
		statistics << characteristics;
	}
	statistics.printAll();

	return 0;
}

