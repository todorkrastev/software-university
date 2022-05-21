#include <iostream>
#include <string>
#include <vector>


int main() {

	int numOfInputs;
	std::cin >> numOfInputs;
	std::cin.ignore();

	std::string continent, country, city;
	std::vector<std::pair<std::string, std::vector<std::pair<std::string, std::vector<std::string>>>>> continents;

	for (size_t i = 0; i < numOfInputs; i++) {
		std::cin >> continent >> country >> city;

		int indexContinent = -1;
		int indexCountry = -1;

		for (size_t currContinent = 0; currContinent < continents.size(); currContinent++) {
			if (continents[currContinent].first == continent) {

				indexContinent = currContinent;
				for (size_t currCountry = 0; currCountry < continents[currContinent].second.size(); currCountry++) {
					if (continents[currContinent].second[currCountry].first == country) {
						indexCountry = currCountry;
						break;
					}
				}
			}
		}

		if (indexContinent == -1) {
			std::vector<std::string> cities;
			cities.push_back(city);

			std::pair<std::string, std::vector<std::string>> countries;
			countries.first = country;
			countries.second = cities;

			std::vector<std::pair<std::string, std::vector<std::string>>> countriesWithCities;
			countriesWithCities.push_back(countries);

			std::pair<std::string, std::vector<std::pair<std::string, std::vector<std::string>>>> continentsWithCountriesAndCities;
			continentsWithCountriesAndCities.first = continent;
			continentsWithCountriesAndCities.second = countriesWithCities;

			continents.push_back(continentsWithCountriesAndCities);
		}
		else if (indexCountry == -1) {
			std::vector<std::string> cities;
			cities.push_back(city);

			std::pair<std::string, std::vector<std::string>> countries;
			countries.first = country;
			countries.second = cities;

			continents[indexContinent].second.push_back(countries);
		}
		else {
			continents[indexContinent].second[indexCountry].second.push_back(city);
		}
	}

	for (size_t currContinent = 0; currContinent < continents.size(); currContinent++) {
		std::cout << continents[currContinent].first << ":";
		std::cout << std::endl;

		for (size_t currCountry = 0; currCountry < continents[currContinent].second.size(); currCountry++) {
			std::cout << "\t" << continents[currContinent].second[currCountry].first << " -> ";

			for (size_t currCity = 0; currCity < continents[currContinent].second[currCountry].second.size(); currCity++) {
				std::cout << continents[currContinent].second[currCountry].second[currCity];

				if (currCity == continents[currContinent].second[currCountry].second.size() - 1) {
					std::cout << std::endl;
				} else {
					std::cout << ", ";
				}
			}
		}
	}

	return 0;
}