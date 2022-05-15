#include <iostream>
#include <queue>
#include <string>


bool checkThePossible(std::queue<int> difference, const int tmp) {

	int sum = tmp;

	for (int i = 0; i < difference.size(); i++) {
		sum += difference.front();

		if (sum < 0) {
			return false;
		}

		difference.push(difference.front());
		difference.pop();
	}

	return true;
}


int main() {

	int pumps;
	std::cin >> pumps;

	std::queue<int> difference;

	for (int i = 0; i < pumps; i++) {
		int amountPetrol, distanceFromPetrolPump;
		std::cin >> amountPetrol >> distanceFromPetrolPump;

		int totalDistPerPoint = amountPetrol - distanceFromPetrolPump;

		difference.push(totalDistPerPoint);
	}

	int index = 0;

	for (int i = 0; i < pumps; i++) {
		int tmp = difference.front();

		difference.pop();
		difference.push(tmp);

		index = i;
		if (checkThePossible(difference, tmp)) {
			break;
		}
	}

	std::cout << index << std::endl;
	return 0;
}