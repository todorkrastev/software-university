#include <iostream>
#include <vector>


int main() {

	std::string command;
	int quantity;

	std::vector<std::pair<std::string, int>> resources;

	while (std::cin >> command) {

		if (command == "stop") {
			break;
		}

		std::cin >> quantity;

	

		bool isResouresRegistered = false;

		for (size_t i = 0; i < resources.size(); i++) {

			if (resources[i].first == command) {
				resources[i].second += quantity;
				isResouresRegistered = true;

				break;
			}
		}

		if (isResouresRegistered == false) {
			std::pair<std::string, int> currResourse;
			currResourse.first = command;
			currResourse.second = quantity;
			resources.push_back(currResourse);
		}
	}


	for (size_t i = 0; i < resources.size(); i++) {

		std::cout << resources[i].first << " -> " << resources[i].second << std::endl;
	}

	return 0;
}