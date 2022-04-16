#include <iostream>
#include <sstream>
#include <string>
#include <map>

int main() {
	std::string essay;
	std::getline(std::cin, essay);

	std::istringstream iss(essay);

	std::map<size_t, size_t> symbolsSentences{ };
	std::string sentence;
	while (std::getline(iss, sentence, '|')) {
		size_t symbols = 0;
		for (char ch : sentence) {
			if (!isalnum(ch) && ch != ' ') {
				++symbols;
			}
		}
		symbolsSentences[symbols]++;
	}

	for (const auto& pair : symbolsSentences) {
		std::cout << pair.first << " symbol sentences: " << pair.second << std::endl;
	}

	return 0;
}