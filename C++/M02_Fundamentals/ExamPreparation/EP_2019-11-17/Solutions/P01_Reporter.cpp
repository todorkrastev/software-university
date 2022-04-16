#include <iostream>
#include <sstream>
#include <vector>
#include <iterator>
#include <algorithm>

int main() {
	size_t lines;
	std::cin >> lines >> std::ws;

	std::vector<std::string> sentence;
	std::stringstream ss;

	while (lines-- > 0) {
		std::string line;
		std::getline(std::cin, line);
		std::istringstream iss(line);

		std::string word;
		while (iss >> word) {
			if (std::find(sentence.begin(), sentence.end(), word) == sentence.end()) {
				sentence.push_back(word);
			}

			if ("." == word) {
				std::move(sentence.begin(), sentence.end(), std::ostream_iterator<std::string>(ss, " "));
				sentence.clear();
			}
		}
	}

	std::move(sentence.begin(), sentence.end(), std::ostream_iterator<std::string>(ss, " "));

	std::cout << ss.str() << std::endl;

	return 0;
}