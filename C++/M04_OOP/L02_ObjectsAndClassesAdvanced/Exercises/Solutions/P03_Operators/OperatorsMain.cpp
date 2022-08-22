#include <iostream>
#include <string>
#include <vector>

#include "Operators.h"

int main() {
	std::vector<std::string> formattedLines;

	int numLines;
	std::cin >> numLines;
	std::cin.ignore();

	std::string heading = "Formatted Lines";
	std::string separator = "----------------";

	formattedLines << heading << separator;

	for (int i = 1; i <= numLines; i++) {
		std::string line;
		std::getline(std::cin, line);

		std::string numberedLine;
		numberedLine = numberedLine + i;
		numberedLine = numberedLine + ". ";
		numberedLine = numberedLine + line;
		numberedLine = numberedLine + " (";
		numberedLine = numberedLine + line.size();
		numberedLine = numberedLine + ")";

		formattedLines << numberedLine;
	}

	formattedLines << separator;

	std::cout << formattedLines;
	std::cout << std::endl;

	return 0;
}