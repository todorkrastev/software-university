#include <iostream>
#include <map>
#include <string>

int main() {

	std::map<std::string, int> playersScore;

	std::string name;

	while (std::cin >> name && name != "End") {
		int victories, loses;

		std::cin >> victories >> loses;

		playersScore[name] += victories;
		playersScore[name] -= loses;
	}

	for (const auto& player : playersScore) {
		std::cout << player.first << " " << player.second << std::endl;
	}

	return 0;
}