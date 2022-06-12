#include <iostream>
#include <list>
#include <sstream>
#include <string>


void printData(const std::pair<std::string, std::pair<std::string, std::string>>& data) {

	std::cout << data.first << "," << data.second.first << "," << data.second.second << std::endl;
}


int main() {

	std::list<std::pair<std::string, std::pair<std::string, std::string>>> data;

	while (true) {

		std::string line;
		std::getline(std::cin, line);

		if (line == ".") {
			break;
		}

		std::istringstream istr(line);

		std::pair<std::string, std::pair<std::string, std::string>> buf;
		std::pair<std::string, std::string>& coords = buf.second;
		std::getline(istr, buf.first, ',');
		std::getline(istr, coords.first, ',');
		std::getline(istr, coords.second, ',');

		data.push_back(buf);
	}

	while (true) {

		std::string line;
		std::getline(std::cin, line);

		if (line == ".") {
			break;
		}

		bool isCity = *line.begin() > '9';

		std::pair<std::string, std::string> coords;
		if (!isCity) {
			std::istringstream istr(line);
			istr >> coords.first >> coords.second;
		}

		std::list<std::pair<std::string, std::pair<std::string, std::string>>>::iterator it = data.begin();

		while (it != data.end()) {
			if (isCity) {
				if (it->first == line) {
					printData(*it);
					break;
				}
			} else {
				if (it->second == coords) {
					printData(*it);
				}
			}

			it++;
		}
	}

	return 0;
}