#include <iostream>
#include <list>
#include <sstream>

void print(const std::list<int>& lst, const std::string& message) {

	if (lst.size() == 0) {
		std::cout << "empty";

		return;
	}

	std::cout << message;

	for (std::list<int>::const_iterator it = lst.begin(); it != lst.end(); it++) {
		std::cout << *it << " ";
	}
}


int main() {

	std::string buf;
	std::getline(std::cin, buf);

	std::istringstream iStr(buf);

	std::list<int> result;
	int digit;

	while (iStr >> digit) {
		if (digit >= 0) {
			result.push_front(digit);
		}
	}

	print(result, "");

	std::cout << std::endl;

	return 0;
}
