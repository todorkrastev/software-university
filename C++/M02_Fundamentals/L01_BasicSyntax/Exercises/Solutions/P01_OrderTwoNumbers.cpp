#include <iostream>
#include <algorithm>

int main() {
	int n1 = 0, n2 = 0;

	std::cin >> n1 >> n2;

	int minNum = std::min(n1, n2);
	int maxNum = std::max(n1, n2);

	std::cout << minNum << " " << maxNum << std::endl;


	return 0;
}