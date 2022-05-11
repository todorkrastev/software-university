#include <iostream>
#include <string>
#include <stack>

int main() {

	std::string str;
	std::getline(std::cin, str);

	std::stack<char> reversed;

	for (size_t i = 0; i < str.length(); i++) {
		reversed.push(str[i]);
	}

	while (!reversed.empty()) {
		std::cout << reversed.top();
		reversed.pop();
	}

	std::cout << std::endl;

	return 0;
}