#include <iostream>
#include <deque>
#include <unordered_map>

int main() {

	std::string firstEmployee = "Pepi";
	std::string secondEmployee = "Mimi";

	int numCommandLines;
	std::cin >> std::ws >> numCommandLines;

	std::unordered_map<std::string, std::deque<std::string>> employees;

	for (size_t k = 0; k < numCommandLines; k++) {
		std::string currEmployeeName;
		std::string currCustomerName;
		int timePeriod;
		std::cin >> std::ws >> currEmployeeName >> currCustomerName >> timePeriod;

		for (size_t m = 0; m < timePeriod; m++) {
			employees[currEmployeeName].push_back(currCustomerName);
		}
	}

	int workingHours;
	std::cin >> std::ws >> workingHours;

	for (size_t i = 0; i < workingHours; i++) {
		if (employees[firstEmployee].empty()) {
			std::cout << "Pepi Idle" << std::endl;
		} else {
			std::cout << "Pepi " << "processing " << employees[firstEmployee].front() << std::endl;
			employees[firstEmployee].pop_front();
		}

		if (employees[secondEmployee].empty()) {
			std::cout << "Mimi Idle" << std::endl;
		} else {
			std::cout << "Mimi " << "processing " << employees[secondEmployee].front() << std::endl;
			employees[secondEmployee].pop_front();
		}
	}

	return 0;
}