#include <iostream>
#include <string>
#include <queue>

int main() {

	std::string input;
	getline(std::cin, input);

	std::queue<std::string> mathExpr1;
	std::queue<std::string> mathExpr2;

	bool isBracketOpen1 = false;
	bool isBracketOpen2 = false;

	int totalBrackets = 0;

	for (size_t i = 0; i < input.length(); i++) {
		char currSymbol = input[i];

		if (currSymbol == '(' && totalBrackets == 0) {
			isBracketOpen1 = true;
			totalBrackets++;

			mathExpr1.push(std::string(1, currSymbol));
		} else if (isBracketOpen1 == true && totalBrackets == 1 && currSymbol != ')' && currSymbol != '(') {
			mathExpr1.push(std::string(1, currSymbol));
		} else if (currSymbol == '(' && totalBrackets == 1) {
			isBracketOpen2 = true;
			totalBrackets++;

			mathExpr2.push(std::string(1, currSymbol));
		} else if (isBracketOpen2 == true && totalBrackets == 2 && currSymbol != ')' && currSymbol != '(') {
			mathExpr2.push(std::string(1, currSymbol));
		} else if (currSymbol == ')' && totalBrackets == 1) {
			isBracketOpen1 = false;
			totalBrackets--;

			mathExpr1.push(std::string(1, currSymbol));

			while (!mathExpr1.empty()) {
				std::cout << mathExpr1.front();
				mathExpr1.pop();
			}

			std::cout << std::endl;
		} else if (currSymbol == ')' && totalBrackets == 2) {
			isBracketOpen2 = false;
			totalBrackets--;

			mathExpr2.push(std::string(1, currSymbol));

			while (!mathExpr2.empty()) {
				mathExpr1.push(mathExpr2.front());
				std::cout << mathExpr2.front();
				mathExpr2.pop();
			}

			std::cout << std::endl;
		}

	}

	return 0;
}