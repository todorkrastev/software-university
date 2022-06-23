#include <iostream>
#include <map>

int main() {

	int digitTown;
	std::cin >> std::ws >> digitTown;

	std::map<std::string, std::pair<double, double>> temperatures;

	while (temperatures.size() < digitTown) {
		std::string currTown;

		double minT;
		double maxT;

		std::cin >> std::ws >> currTown >> minT >> maxT;

		std::map<std::string, std::pair<double, double>>::const_iterator found = temperatures.find(currTown);

		if (found == temperatures.end()) {
			temperatures[currTown].first = minT;
			temperatures[currTown].second = maxT;
		}

		if (minT < temperatures[currTown].first) {
			temperatures[currTown].first = minT;
		}

		if (temperatures[currTown].second < maxT) {
			temperatures[currTown].second = maxT;
		}
	}

	std::map<std::string, std::pair<double, double>>::const_iterator it;

	for (it = temperatures.begin(); it != temperatures.end(); it++) {
		std::cout << it->first << " " << it->second.first << " " << it->second.second << std::endl;
	}


	return 0;
}