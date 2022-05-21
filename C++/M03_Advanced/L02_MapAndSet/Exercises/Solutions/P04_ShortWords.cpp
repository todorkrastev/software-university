#include <iostream>
#include <string>
#include <sstream>
#include <algorithm>
#include <map>


int main() {

	std::string input;
	std::getline(std::cin, input);
	std::transform(input.begin(), input.end(), input.begin(), [](unsigned char c) { return std::tolower(c); });
	std::istringstream strStream(input);

	std::string currWord;
	std::map<std::string, int> result;

	while (strStream >> currWord) {
		if (currWord.length() < 5) {
			result[currWord] = currWord.length();
		}
	}

	std::map<std::string, int>::iterator itr;

	for (itr = result.begin(); itr != result.end(); itr++) {
		if (itr != result.begin()) {
			std::cout << ", ";
		}
		std::cout << itr->first;
	}


	return 0;
}