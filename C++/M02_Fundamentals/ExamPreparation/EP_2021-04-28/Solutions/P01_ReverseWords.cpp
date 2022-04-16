#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <sstream>

int main() {

	std::string input;
	getline(std::cin, input);

	if (input == "end") {
		return 0;
	}

	std::vector <std::string> text;

	while (input != "end") {
		std::istringstream lineStream(input);
		std::string currWord;
		while (lineStream >> currWord) {
			text.push_back(currWord);
		}

		getline(std::cin, input);
	}

	std::reverse(text.begin(), text.end());

	for (size_t i = 0; i < text.size(); i++) {
		std::cout << text[i] << " ";
	}

	return 0;
}

// -------------------------------------------------------------------------------------------

// Refactoring 

// -------------------------------------------------------------------------------------------


#include <iostream>
#include <sstream>
#include <vector>
#include <iterator>

int main() {
	std::vector<std::string> words{ };

	std::string line;
	while (std::getline(std::cin, line) && line != "end") {
		std::istringstream ss(line);
		std::string word;
		while (ss >> word) {
			words.emplace_back(word);
		}
	}

	std::copy(words.crbegin(), words.crend(), std::ostream_iterator<std::string>(std::cout, " "));

	return 0;
}