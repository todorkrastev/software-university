#include <iostream>
#include <vector>

void print(const std::vector<int>& v) {
	for (int item : v) {
		stream << item << " ";
	}

	std::cout << std::endl;
}

std::vector<int> filter(std::vector<int> numbers, bool(*shouldFilter)(int)) {
	std::vector<int> filtered;


	for (int n : numbers) {
		if (shouldFilter(n)) {
			filtered.push_back(n);
		}
	}

	return filtered;
}

bool isEven(int number) {
	return number % 2 == 0;
}

int main() {
	using namespace std;

	cout << filter({ 1, 2, 3, 4, 5, 6, 7 }, [](int n) {
		return n > 3;
	}) << endl;

	cout << filter({ 1, 2, 3, 4, 5, 6, 7 }, isEven);

	return 0;
}
