#include <iostream>
#include <string>

int main() {
	std::string n1, n2, n3;
	std::cin >> n1 >> n2 >> n3;

	int counter = 0;

	if (n1[0] == '-') {
		counter++;
	}
	if (n2[0] == '-') {
		counter++;
	}
	if (n3[0] == '-') {
		counter++;
	}

	std::cout << (counter % 2 == 0 ? "+" : "-") << std::endl;

	return 0;
}