#include <iostream>
#include <set>
#include <string>
#include <sstream>


int main() {

	std::set<std::string> mendeleevsTable;

	int numOfInputs;
	std::cin >> numOfInputs;
	std::cin.ignore();


	for (size_t i = 0; i < numOfInputs; i++) {
		std::string input;
		std::getline(std::cin, input);
		std::istringstream strStream(input);

		std::string currChemEl;

		while (strStream >> currChemEl) {
			mendeleevsTable.insert(currChemEl);
		}
	}

	std::set<std::string>::iterator itr;

	for (itr = mendeleevsTable.begin(); itr != mendeleevsTable.end(); itr++) {
		std::cout << *itr << " ";
	}

	return 0;
}