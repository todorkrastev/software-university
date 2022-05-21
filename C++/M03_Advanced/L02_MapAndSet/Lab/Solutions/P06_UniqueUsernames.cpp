#include <iostream>
#include <vector>
#include <string>
#include <algorithm>


int main() {

	std::vector<std::string> names;

	int numOfInputs;
	std::cin >> numOfInputs;
	
	std::string input;

	for (size_t i = 0; i < numOfInputs; i++) {

		std::cin >> input;

		if (std::find(names.begin(), names.end(), input) == names.end()) {
			names.push_back(input);
		}
	}

	for (size_t i = 0; i < names.size(); i++) {
		std::cout << names[i] << std::endl;
	}

	return 0;
}