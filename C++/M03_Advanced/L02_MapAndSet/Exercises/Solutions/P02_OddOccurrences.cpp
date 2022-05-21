#include <iostream>
#include <algorithm>
#include <cctype>
#include <string>
#include <sstream>
#include <vector>

int main() {

	std::string data;
	std::getline(std::cin, data);
	std::transform(data.begin(), data.end(), data.begin(), [](unsigned char c) { return std::tolower(c); });
	std::istringstream strStream(data);

	std::vector<std::pair<std::string, int>> occurrences;
	std::string currWord;
	std::vector<std::pair<std::string, int>>::iterator itr;

	while (strStream >> currWord) {

		bool doesWordExist = false;

		for (itr = occurrences.begin(); itr != occurrences.end(); itr++) {
			if (itr->first == currWord) {
				itr->second += 1;
				doesWordExist = true;

				break;
			}
		}

		if (doesWordExist == false) {
			std::pair<std::string, int> currPair;
			currPair.first = currWord;
			currPair.second = 1;

			occurrences.push_back(currPair);
		}
	}

	std::vector<std::string> result;

	for (size_t i = 0; i < occurrences.size(); i++) {
		if (occurrences[i].second % 2 == 1) {
			result.push_back(occurrences[i].first);
		}
	}

	std::vector<std::string>::iterator it;

	for (it = result.begin(); it != result.end(); it++) {
		if (it != result.begin()) {
			std::cout << ", ";
		}
		std::cout << *it;
	}

	return 0;
}