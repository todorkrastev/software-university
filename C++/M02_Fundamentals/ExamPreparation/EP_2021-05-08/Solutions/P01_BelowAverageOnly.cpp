#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>
#include <numeric>


int main() {

	int numbersCount;
	std::cin >> numbersCount;
	std::vector<int> numbers(numbersCount);
	std::copy_n(std::istream_iterator<int>(std::cin), numbersCount, numbers.begin());

	const double sum = std::accumulate(numbers.cbegin(), numbers.cend(), 0.0);
	const double average = sum / numbersCount;

	int evenSum = 0;
	int oddSum = 0;
	int index = 0;

	for (std::vector<int>::iterator it = numbers.begin(); it != numbers.end(); it++) {
		int currNum = *it;

		if (currNum <= average) {
			if (index % 2 == 0) {
				evenSum += currNum;
			} else {
				oddSum += currNum;
			}
		}

		index++;
	}

	std::cout << evenSum * oddSum << std::endl;

	return 0;
}

// -----------------------------------------------------------------------------------------------

// Refactoring

// -----------------------------------------------------------------------------------------------


#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>
#include <numeric>

int main() {
	int numbersCount;
	std::cin >> numbersCount;
	std::vector<int> numbers(numbersCount);
	std::copy_n(std::istream_iterator<int>(std::cin), numbersCount, numbers.begin());

	const int sum = std::accumulate(numbers.begin(), numbers.end(), 0);
	const int average = sum / numbersCount;

	int evenSum = 0, oddSum = 0;

	for (int i = 0; i < numbersCount; ++i) {
		if (numbers[i] > average) { continue; }
		int* targetSum = (i % 2 == 0) ? &evenSum : &oddSum;
		*targetSum += numbers[i];
	}

	const long result = evenSum * oddSum;
	std::cout << result << std::endl;

	return 0;
}