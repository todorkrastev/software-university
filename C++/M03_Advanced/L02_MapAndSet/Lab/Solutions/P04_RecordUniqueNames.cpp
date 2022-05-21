#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

int main() {

	int numOfNames;
	std::cin >> numOfNames;
	std::string name;

	std::vector<std::string> names;

	for (size_t i = 0; i < numOfNames; i++) {

		std::cin >> name;

		if (std::find(names.begin(), names.end(), name) == names.end()) {
			names.push_back(name);
		}
	}

	for (size_t i = 0; i < names.size(); i++) {
		std::cout << names[i] << std::endl;
	}

	return 0;
}