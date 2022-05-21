#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <algorithm>
#include <iterator>
#include <numeric>


int main() {

	std::string input;
	std::getline(std::cin, input);
	std::istringstream strStream(input);

	std::string currNum;
	std::vector<double> topNums;

	while (strStream >> currNum) {
		topNums.push_back(std::stod(currNum));
	}

	std::sort(topNums.begin(), topNums.end(), std::greater<double>());

	if (3 < topNums.size()) {
		topNums.resize(3);
	}

	std::copy(topNums.cbegin(), topNums.cend(), std::ostream_iterator<double>(std::cout, " "));

	return 0;
}