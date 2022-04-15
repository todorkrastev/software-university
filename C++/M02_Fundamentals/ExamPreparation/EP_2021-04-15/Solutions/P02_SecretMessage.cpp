#include <iostream>
#include <string>
#include <ctype.h>


int main() {

	std::string input;
	getline(std::cin, input);

	int sum = 0;

	for (size_t i = 0; i < input.size(); i++) {
		char currSym = input[i];

		if (isdigit(currSym)) {
			int currDigit = currSym - 48;

			sum += currDigit;
		}
	}

	
	if ((65 <= sum && sum <= 90) || (97 <= sum && sum <= 122)) {
		char result = (char)sum;
		std::cout << result << std::endl;
	}
	else {
		std::cout << sum << std::endl;
	}

	return 0;
}


// --------------------------------------------------------------------------

// Second option

// --------------------------------------------------------------------------

#include <iostream>
#include <algorithm>
#include <numeric>

int main() {
	std::string message;
	std::getline(std::cin, message);

	const int sum = std::accumulate(message.cbegin(), message.cend(), 0, [](int acc, const char ch) {
		if (std::isdigit(ch)) {
			acc += ch - '0';
		}
		return acc;
		});

	if (isalpha(sum)) {
		std::cout << char(sum);
	}
	else {
		std::cout << sum;
	}

	return 0;
}