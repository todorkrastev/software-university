#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include <numeric>
#include <algorithm>


int main() {

	std::string input;
	std::getline(std::cin, input);
	int arraySize = std::stoi(input);
	std::vector<int> numbers;

	std::string line;
	std::getline(std::cin, line);
	std::istringstream lineStream(line);

	int currNumber;

	while (lineStream >> currNumber) {
		numbers.push_back(currNumber);
	}

	std::sort(numbers.begin(), numbers.end(), std::greater<int>());

	double sumOfElements = std::accumulate(numbers.cbegin(), numbers.cend(), 0.0);
	// int sumOfElements = std::accumulate(numbers.begin(), numbers.end(), 0); -> for integers

	double average = sumOfElements / numbers.size();

	int counter = 0;
	for (std::vector<int>::iterator it = numbers.begin(); it != numbers.end(); it++) {
		double currNum = *it;

		if (counter == 5) {

			return 0;
		} else if (average < currNum) {

			std::cout << currNum << " ";

			counter++;
		}


	}

	if (counter == 0) {
		std::cout << "No" << std::endl;
	}

	std::cout << std::endl;

	return 0;
}


// -------------------------------------------------------------------------------------

// Second option

// -------------------------------------------------------------------------------------


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

  const auto& newEnd = std::remove_if(
	  numbers.begin(), numbers.end(), [&average](int current) {
		return current <= average;
	  });

  numbers.erase(newEnd, numbers.end());

  std::sort(numbers.begin(), numbers.end(), std::greater<>());

  if (numbers.size() > 5) {
	numbers.resize(5);
  }

  if (numbers.empty()) {
	std::cout << "No" << std::endl;
  } else {
	std::copy(numbers.cbegin(), numbers.cend(), std::ostream_iterator<int>(std::cout, " "));
  }

  return 0;
}
