#include <iostream>
#include <string>
#include <ctype.h>
#include <algorithm>
#include <cctype>


int main() {

	std::string input, text1, text2;
	getline(std::cin, input);
	int size = stoi(input);
	getline(std::cin, text1);
	getline(std::cin, text2);

	int counter = 0;

	for (size_t i = 0; i < size; i++) {
		char currSym1 = text1[i];
		char currSym2 = text2[i];

		if (isalpha(currSym1) && isalpha(currSym2)) {
			std::string currLetter1(1, currSym1);
			std::string currLetter2(1, currSym2);


			if (currLetter1 == currLetter2) {
				std::cout << currLetter1;
			} else {

				std::transform(currLetter1.begin(), currLetter1.end(), currLetter1.begin(), [](unsigned char c) {return std::toupper(c); });
				std::transform(currLetter2.begin(), currLetter2.end(), currLetter2.begin(), [](unsigned char c) {return std::toupper(c); });

				if (currLetter1 == currLetter2) {
					std::cout << currLetter1;
				} else {
					std::cout << "!";
					counter++;
				}
				
			}
		} else if (isdigit(currSym1) && isdigit(currSym2)) {
			int currDigit1 = currSym1 - 48;
			int currDigit2 = currSym2 - 48;

			if (currDigit1 == currDigit2) {
				std::cout << currDigit1;
			} else {
				std::cout << "!";
				counter++;
			}
		} else {
			std::string currElement1(1, currSym1);
			std::string currElement2(1, currSym2);

			if (currElement1 == currElement2) {
				std::cout << currElement1;
			} else {
				std::cout << "!";
				counter++;
			}
		}
	}

	std::cout << std::endl;

	std::cout << counter << std::endl;

	return 0;
}


// --------------------------------------------------------------------------------------------

// Second option

// --------------------------------------------------------------------------------------------


#include <iostream>
#include <vector>
#include <iterator>
#include <algorithm>

int main() {
	size_t size;
	std::cin >> size;

	std::vector<char> first(size);
	std::vector<char> second(size);
	std::vector<char> dif(size);

	std::copy_n(std::istream_iterator<char>(std::cin >> std::ws), size, first.begin());
	std::copy_n(std::istream_iterator<char>(std::cin >> std::ws), size, second.begin());

	for (size_t i = 0; i < size; ++i) {
		const char firstChar = first[i];
		const char secondChar = second[i];
		char difChar = '!';
		if (firstChar == secondChar) {
			difChar = firstChar;
		}
		else if (toupper(firstChar) == toupper(secondChar)) {
			difChar = char(toupper(firstChar));
		}
		dif[i] = difChar;
	}

	std::copy(dif.cbegin(), dif.cend(), std::ostream_iterator<char>(std::cout, ""));
	std::cout << std::endl << std::count(dif.cbegin(), dif.cend(), '!');

	return 0;
}
