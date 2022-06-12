#include <iostream>
#include <algorithm>
#include <cctype>
#include <set>
#include <sstream>
#include <string>
#include <vector>

std::string deleteDigit(std::string& currWord) {

	std::string strWithoutDigits;

	for (size_t i = 0; i < currWord.length(); i++) {

		if (isalpha(currWord[i])) {
			strWithoutDigits += currWord[i];
		}
	}

	return strWithoutDigits;
}

std::vector<std::string> getLine(std::set<std::string>& words, char& ch) {

	std::vector<std::string> line;

	if (isalpha(ch)) {

		for (std::set<std::string>::iterator it = words.begin(); it != words.end(); it++) {
			std::string currWord = *it;

			std::transform(currWord.begin(), currWord.end(), currWord.begin(), [](unsigned char c) { return std::tolower(c); });

			if (currWord.find(tolower(ch)) != std::string::npos) {
				line.push_back(*it);
			}
		}
	}

	if (line.empty()) {
		line.push_back("---");
	}

	return line;
}

void printOutput(std::vector<std::vector<std::string>>& result) {
	for (size_t i = 0; i < result.size(); i++) {
		for (size_t currLine = 0; currLine < result[i].size(); currLine++) {
			std::cout << result[i][currLine] << " ";
		}
		std::cout << std::endl;
	}
}

int main() {

	std::string text;
	std::getline(std::cin, text);


	std::stringstream istr(text);
	std::string currWord;
	std::set<std::string> words;

	while (istr >> currWord) {
		currWord.erase(remove(currWord.begin(), currWord.end(), ','), currWord.end());
		currWord.erase(remove(currWord.begin(), currWord.end(), '.'), currWord.end());

		currWord = deleteDigit(currWord);

		words.insert(currWord);
	}

	char ch;
	std::cin >> ch;

	std::vector<std::vector<std::string>> result;

	while (ch != '.') {

		std::vector<std::string> line;

		line = getLine(words, ch);

		result.push_back(line);

		std::cin >> ch;
	}

	printOutput(result);

	return 0;
}

// -----------------------------------------------------------------------------------------------

// Second Option

// -----------------------------------------------------------------------------------------------


#include <iostream>
#include <algorithm>
#include <map>
#include <set>
#include <string>
#include <sstream>

void skip_non_alphanumeric(std::string& str) {

	std::string::iterator itS;
	for (itS = str.begin(); itS != str.end(); ) {
		if (*itS >= 'a' && *itS <= 'z' || *itS >= 'A' && *itS <= 'Z') {
			itS++;
		}
		else {
			itS = str.erase(itS);
		}
	}
}

int main() {

	std::string line;
	std::getline(std::cin, line);

	std::istringstream istr(line);

	std::map<std::string, std::string> words;
	std::string buff;

	while (istr >> buff) {
		std::string key = buff;
		skip_non_alphanumeric(key);
		skip_non_alphanumeric(buff);

		if (words.find(key) == words.end()) {
			words[key] = buff;
		}
	}

	while (std::cin >> buff) {
		if (buff == ".") {
			break;
		}

		std::transform(buff.begin(), buff.end(), buff.begin(), ::toupper);

		std::set<std::string> foundWords;
		std::map<std::string, std::string>::iterator itCur;

		for (itCur = words.begin(); itCur != words.end(); itCur++) {
			std::string key = itCur->first;
			std::transform(key.begin(), key.end(), key.begin(), ::toupper);

			if (key.find_first_of(buff) < key.length()) {
				foundWords.insert(itCur->second);
			}
		}

		if (foundWords.size()) {
			for (std::set<std::string>::iterator itS = foundWords.begin(); itS != foundWords.end(); itS++) {
				std::cout << *itS << " ";
			}
		}
		else {
			std::cout << "---";
		}

		std::cout << std::endl;
	}

	return 0;
}