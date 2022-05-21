#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>

int main() {

	std::string input;
	getline(std::cin, input);

	if (input == "END") {
		std::cout << "Parking Lot is Empty" << std::endl;

		return 0;
	}

	std::vector<std::pair<bool, std::string>> cars;
	std::string splitEl;

	while (input != "END") {

		std::replace(input.begin(), input.end(), ',', ' ');
		std::istringstream streamLine(input);

		std::pair<bool, std::string> car;
		std::vector<std::string> carInfo;

		while (streamLine >> splitEl) {
			carInfo.push_back(splitEl);
		}

		bool isCarRegistered = false;

		for (size_t i = 0; i < cars.size(); i++) {
			if (cars[i].second == carInfo[1]) {
				if (carInfo[0] == "IN") {
					car.first = true;
				} else if (carInfo[0] == "OUT") {
					cars.erase(std::next(cars.begin(), i), std::next(cars.begin(), i + 1));
				}

				isCarRegistered = true;

				break;
			}
		}

		if (isCarRegistered == false) {
			if (carInfo[0] == "IN") {
				car.first = true;
				car.second = carInfo[1];
				cars.push_back(car);
			}
		}

		getline(std::cin, input);
	}

	if (cars.empty()) {
		std::cout << "Parking Lot is Empty" << std::endl;
	} else {
		for (size_t i = 0; i < cars.size(); i++) {
			std::cout << cars[i].second << std::endl;

		}
	}

	return 0;
}