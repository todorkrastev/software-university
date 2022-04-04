#include <iostream>


std::string numberTeen(unsigned d) {
	switch (d) {
	case 10: return "ten"; break;
	case 11: return "eleven"; break;
	case 12: return "twelve";  break;
	case 13: return "thirteen"; break;
	case 14: return "fourteen"; break;
	case 15: return "fifteen"; break;
	case 16: return "sixteen"; break;
	case 17: return "seventeen"; break;
	case 18: return "eighteen"; break;
	case 19: return "nineteen"; break;
	}

	return "unknown";
}

std::string numberDecimals(unsigned d) {
	switch (d) {
	case 0: return ""; break;
	case 1: return ""; break;
	case 2: return "twenty";  break;
	case 3: return "thirty"; break;
	case 4: return "fourty"; break;
	case 5: return "fifty"; break;
	case 6: return "sixty"; break;
	case 7: return "seventy"; break;
	case 8: return "eighty"; break;
	case 9: return "ninety"; break;
	}

	return "unknown";
}

std::string numberName(unsigned d) {
	switch (d) {
	case 0: return "zero"; break;
	case 1: return "one"; break;
	case 2: return "two";  break;
	case 3: return "three"; break;
	case 4: return "four"; break;
	case 5: return "five"; break;
	case 6: return "six"; break;
	case 7: return "seven"; break;
	case 8: return "eight"; break;
	case 9: return "nine"; break;
	}

	return "unknown";
}



int main(void) {
	unsigned n;

	std::cin >> n;

	int thousands = n / 1000;
	int hundreds = (n % 1000) / 100;
	int decimals = (n % 100) / 10;
	int single = n % 10;

	if (thousands) {
		std::cout << numberName(thousands) << " thousand ";
	}

	if (hundreds) {
		std::cout << numberName(hundreds) << " hundred ";
	}

	if (decimals >= 2) {
		std::cout << numberDecimals(decimals);

		if (single) {
			std::cout << " " << numberName(single);
		}
	} else {
		if (decimals == 1) {
			std::cout << numberTeen(n % 100);
		} else {
			if (n == 0 || single != 0) {
				std::cout << numberName(single);
			}
		}
	}

	std::cout << std::endl;
}
