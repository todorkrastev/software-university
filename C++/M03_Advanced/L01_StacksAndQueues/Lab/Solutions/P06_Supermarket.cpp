#include <iostream>
#include <string>
#include <queue>
#include <vector>


int main() {

	std::string input;
	std::cin >> input;

	std::queue<std::string> names;
	std::vector<std::string> output;
	
	while (input != "End") {
		if (input != "Paid") {
			names.push(input);
		} else {
			while (!names.empty()) {
				output.push_back(names.front());
				names.pop();
			}
		}

		std::cin >> input;
	}

	for (std::vector<std::string>::iterator it = output.begin(); it != output.end(); it++) {
		  std::cout << *it << std::endl;
	}
	std::cout << names.size() << " people remaining" << std::endl;

	return 0;
}