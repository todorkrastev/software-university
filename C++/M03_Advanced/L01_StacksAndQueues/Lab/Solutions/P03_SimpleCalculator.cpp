#include <iostream>
#include <string>
#include <sstream>
#include <stack>


int main() {

	std::string input;
	std::getline(std::cin, input);
	std::istringstream lineStream(input);
	std::string currElement;

	std::stack<std::string> calculator;

	std::string mathSign;

	int currNum = 0;
	int prevNum = 0;
	int result = 0;

	while (lineStream >> currElement) {

		if (2 <= calculator.size()) {
			currNum = stoi(currElement);

			mathSign = calculator.top();
			calculator.pop();

			prevNum = stoi(calculator.top());
			calculator.pop();

			if (mathSign == "+") {
				calculator.push(std::to_string(prevNum + currNum));
			} else if (mathSign == "-") {
				calculator.push(std::to_string(prevNum - currNum));
			}
		} else {
			calculator.push(currElement);
		}
	}

	std::cout << calculator.top() << std::endl;

	return 0;
}