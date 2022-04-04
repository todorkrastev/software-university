#include <iostream>
#include <string>

std::string getGrade(double grade) {

	std::string output = "";

	if (2 <= grade && grade <= 2.99) {
		output = "Fail";
	} else if (3 <= grade && grade <= 3.49) {
		output = "Poor";
	} else if (3.5 <= grade && grade <= 4.49) {
		output = "Good";
	} else if (4.5 <= grade && grade <= 5.49) {
		output = "Very good";
	} else if (5.5 <= grade && grade <= 6) {
		output = "Excellent";
	}

	return output;
}


int main() {

	double num;
	std::cin >> num;

	std::cout << getGrade(num) << std::endl;

	return 0;
}