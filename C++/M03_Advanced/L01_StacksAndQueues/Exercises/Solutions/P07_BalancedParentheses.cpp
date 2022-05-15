#include <iostream>
#include <string>
#include <stack>

int main() {

	std::stack<char> brackets;
	std::string input;

	getline(std::cin, input);

	bool isValid = true;

	for (char currBracket : input) {

		switch (currBracket) {
		case '(':
			brackets.push(')');
			break;
		case '{':
			brackets.push('}');
			break;
		case '[':
			brackets.push(']');
			break;
		case ')':
		case '}':
		case ']':
			if (brackets.empty() || brackets.top() != currBracket) {
				isValid = false;
			} else {
				brackets.pop();
			}
			break;
		default:
			break;
		}

		if (!isValid) {
			break;
		}
	}

	if (isValid && brackets.empty()) {
		std::cout << "YES" << std::endl;
	} else {
		std::cout << "NO" << std::endl;
	}

	return 0;
}