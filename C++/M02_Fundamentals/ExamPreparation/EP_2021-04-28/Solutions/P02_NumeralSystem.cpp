#include <iostream>
#include <string>
#include <ctype.h>
#include <algorithm>


int main() {

	std::string text, line1, line2;
	std::cin >> text >> line1 >> line2;

	int multiplier = 10;
	int number = 0;

	for (size_t k = 0; k < line1.length(); k++) {
		char currSymLine = line1[k];

		int index = text.find(currSymLine);
		number *= 10;
		number += (index);
	}

	int sum = number;

	number = 0;

	for (size_t k = 0; k < line2.length(); k++) {
		char currSymLine = line2[k];

		int index = text.find(currSymLine);
		number *= 10;
		number += (index);
	}

	sum += number;

	std::string sumToStr = std::to_string(sum);

	for (size_t i = 0; i < sumToStr.length(); i++) {
		int index = sumToStr[i] - 48;

		std::cout << text[index];
	}

	return 0;
}

// -------------------------------------------------------------------------------------------

// refactoring

// -------------------------------------------------------------------------------------------

#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>

int decode(const std::vector<char>& digits, const std::vector<char>& encoded);

std::string encode(const std::vector<char>& digits, int number);

int main() {
	std::vector<char> digits(10);
	std::copy_n(std::istream_iterator<char>(std::cin >> std::ws), 10, digits.begin());

	std::string input;
	std::getline(std::cin >> std::ws, input);
	const std::vector<char> first(input.cbegin(), input.cend());

	std::getline(std::cin >> std::ws, input);
	const std::vector<char> second(input.cbegin(), input.cend());

	const int firstNum = decode(digits, first);
	const int secondNum = decode(digits, second);
	const int sum = firstNum + secondNum;

	std::string encoded = encode(digits, sum);

	std::cout << encoded;

	return 0;
}

std::string encode(const std::vector<char>& digits, const int number) {
	std::string encoded{ };
	for (char ch : std::to_string(number)) {
		encoded += digits[ch - '0'];
	}
	return encoded;
}

int decode(const std::vector<char>& digits, const std::vector<char>& encoded) {
	int decoded = 0;
	for (char ch : encoded) {
		decoded *= 10;
		int value = (int)std::distance(digits.cbegin(), std::find(digits.cbegin(), digits.cend(), ch));
		decoded += value;
	}
	return decoded;
}