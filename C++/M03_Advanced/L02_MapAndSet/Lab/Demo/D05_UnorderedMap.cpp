#include <iostream>
#include <string>
#include <utility>
#include <unordered_map>

int main() {
	using namespace std;

	unordered_map<string, int> cityPopulations = {
		pair<string, int>{"Gabrovo", 58950},
		pair<string, int>{"Sofia", 58950},
		pair<string, int>{"Melnik", 385},
	};

	cityPopulations["Sofia"]++;
	cityPopulations["Veliko Tarnovo"] = 72938;
	cityPopulations.insert(pair<string, int>("Pliska", 0));

	unordered_map<string, int>::iterator it;
	for (it = cityPopulations.begin(); it != cityPopulations.end(); it++) {
		cout << it->first << " " << it->second << endl;
	}

	cout << endl;

	// "Pliska" isn't really a city, it's an ancient settlement, let's remove it
	cityPopulations.erase("Pliska");

	for (pair<string, int> element : cityPopulations) {
		cout << element.first << " " << element.second << endl;
	}

	cout << endl;

	cout << "Enter a city name to see it's population:" << endl;
	string searchCityName;
	getline(cin, searchCityName);

	unordered_map<string, int>::iterator foundCity =
		cityPopulations.find(searchCityName);

	if (foundCity != cityPopulations.end()) {
		cout << foundCity->first << " " << foundCity->second << endl;
	} else {
		cout << "No information about " << searchCityName << endl;
	}

	return 0;
}