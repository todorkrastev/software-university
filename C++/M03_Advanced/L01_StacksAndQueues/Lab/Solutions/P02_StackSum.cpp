#include <iostream>
#include <string>
#include <algorithm>
#include <cctype>
#include <sstream>
#include <stack>



int main() {

	std::stack<int> nums;
	std::string input;
	std::getline(std::cin, input);
	std::istringstream lineStream(input);
	int currElement;

	while (lineStream >> currElement) {
		nums.push(currElement);
	}

	std::getline(std::cin, input);

	while (input != "end") {

		std::istringstream istr(input);
		std::string currElement;

		while (istr >> currElement) {

			std::transform(currElement.begin(), currElement.end(), currElement.begin(), [](unsigned char c) { return std::tolower(c); });

			if (currElement == "add") {
				int firstN, secondN;
				istr >> firstN >> secondN;

				nums.push(firstN);
				nums.push(secondN);
			} else if (currElement == "remove") {
				int toRemove;
				istr >> toRemove;

				if (toRemove <= nums.size()) {
					for (size_t i = 0; i < toRemove; i++) {
						nums.pop();
					}
				}	
			}
		}

		std::getline(std::cin, input);
	}

	int sum = 0;
	while (!nums.empty()) {
		sum += nums.top();
		nums.pop();
	}

	std::cout << "Sum: " << sum << std::endl;

	return 0;
}
