#include <stdlib.h>  
#include <time.h>       
#include <stdio.h>
#include <string>
#include <iostream>


std::string generateSomeJunk() {

	int junkSize = rand() % 5;

	std::string strJib;

	while (junkSize) {

		char c = rand() % (128 - ' ') + ' ';

		if (c == '.' || (c >= '0' && c <= '9'))
			continue;

		strJib += c;
		junkSize--;
	}

	return strJib;
}

int main(void)
{
	srand(time(NULL));

	int number = rand() % 46340 + 1; 

	int numbersquare = number * number;

	std::string strResult = ".";

	while (numbersquare) {

		strResult = generateSomeJunk() + strResult;

		int ones = numbersquare % 10;
		char str[2];
		str[0] = ones + '0';
		str[1] = '\0';

		strResult = str + strResult;

		numbersquare /= 10;
	}

	strResult = generateSomeJunk() + strResult;

	std::cout << "The number is " << number * number << ", which is square of " << number << "." << std::endl;
	std::cout << strResult << std::endl;

	return 0;
}
