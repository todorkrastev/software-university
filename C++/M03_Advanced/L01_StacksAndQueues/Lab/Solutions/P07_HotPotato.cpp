#include <iostream>
#include <string>
#include <sstream>
#include <deque>
#include "P07_HotPotato.h"


void defineStartingPosition(int rounds, std::deque<std::string>::iterator& it, std::deque<std::string>& participants) {
	for (int i = 1; i < rounds; i++) {
		it++;

		if (it == participants.end()) {
			it = participants.begin();
		}
	}
}

int main() {

	std::string input;
	getline(std::cin, input);
	std::istringstream lineStream(input);
	std::string currParticipant;

	std::deque<std::string> participants;

	while (lineStream >> currParticipant) {
		participants.push_back(currParticipant);
	}

	int rounds;
	std::cin >> rounds;

	int counter = 1;
	std::deque<std::string>::iterator it;
	it = participants.begin();

	if (!participants.empty()) {
		while (participants.size() != 1) {

			if (counter == rounds) {
				defineStartingPosition(rounds, it, participants);

				std::cout << "Removed " << *it << std::endl;
				participants.erase(it);

				it = participants.begin();

				defineStartingPosition(rounds, it, participants);

				counter = 0;
			}

			counter++;
		}
	}

	std::cout << "Last is " << participants[0] << std::endl;


	return 0;
}



// Second option



#include <iostream>
#include <string>
#include <sstream>
#include <queue>


int main() {

	std::string str;
	getline(std::cin, str);
	std::istringstream istr(str);

	std::queue<std::string> circle;
	std::string kid;
	
	while (istr >> kid) {
		circle.push(kid);
	}

	int throws;
	std::cin >> throws;

	int remaining = throws;

	while (circle.size() > 1) {
		kid = circle.front();
		circle.pop();
		remaining--;

		if (remaining == 0) {
			std::cout << "Removed " << kid << std::endl;
			remaining = throws;
		} else {
			circle.push(kid);
		}
	}

	std::cout << "Last is " << circle.front() << std::endl;

	return 0;
}