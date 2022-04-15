#include <iostream>
#include <string>
#include <vector>

bool isNumber(const std::string& str) {
	for (char const& c : str) {
		if (std::isdigit(c) == 0) return false;
	}
	return true;
}

void sum(std::vector<int>& numbers) {
	int sum = 0;

	int num1 = numbers.back();
	numbers.pop_back();

	int num2 = numbers.back();
	numbers.pop_back();

	sum = num1 + num2;

	numbers.push_back(sum);
}

void substract(std::vector<int>& numbers) {
	int diff = 0;

	int num1 = numbers.back();
	numbers.pop_back();

	int num2 = numbers.back();
	numbers.pop_back();

	diff = num1 - num2;

	numbers.push_back(diff);
}

void concat(std::vector<int>& numbers) {
	int number1 = numbers.end()[-2];
	int number2 = numbers.back();

	numbers.pop_back();
	numbers.pop_back();

	std::string num1 = std::to_string(number1);
	std::string num2 = std::to_string(number2);

	std::string result = num1 + num2;
	int num = stoi(result);

	numbers.push_back(num);
}


int main() {

	std::string input;
	getline(std::cin, input);

	if (input == "end") {
		return 0;
	}

	std::vector<int> numbers;


	while (true) {

		if (isNumber(input)) {
			int currNum = stoi(input);

			numbers.push_back(currNum);
		} else {
			if (input == "sum") {
				sum(numbers);
			} else if (input == "substract") {
				substract(numbers);
			} else if (input == "concat") {
				concat(numbers);
			} else if (input == "discard") {
				numbers.pop_back();
			} else {
				int currNum = stoi(input);

				numbers.push_back(currNum);
			}
		}

		getline(std::cin, input);

		if (input == "end") {
			break;
		}
	}


	for (std::vector <int> ::iterator it = numbers.begin(); it != numbers.end(); it++) {
		std::cout << *it << std::endl;
	}


	return 0;
}

// -------------------------------------------------------------------------------------------

// refactoring

// -------------------------------------------------------------------------------------------


#include <iostream>
#include <utility>
#include <vector>
#include <iterator>

class Machine {
	std::vector<int> numbers{ };
public:
	void sum() {
		const int first = numbers.back();
		numbers.pop_back();
		const int second = numbers.back();
		numbers.pop_back();

		const int sum = first + second;

		numbers.emplace_back(sum);
	}

	void subtract() {
		const int minuend = numbers.back();
		numbers.pop_back();
		const int subtrahend = numbers.back();
		numbers.pop_back();

		const int difference = minuend - subtrahend;

		numbers.emplace_back(difference);
	}

	void concat() {
		const int second = numbers.back();
		numbers.pop_back();
		const int first = numbers.back();
		numbers.pop_back();

		const std::string concatStr = std::to_string(first) + std::to_string(second);

		numbers.emplace_back(std::stoi(concatStr));
	}

	void discard() {
		numbers.pop_back();
	}

	void push(int num) {
		numbers.emplace_back(num);
	}

	void print(std::ostream& os) {
		std::copy(numbers.begin(), numbers.end(),
			std::ostream_iterator<int>(os, "\n"));
	}
};

class CommandProcessor {
	Machine machine;
	std::istream& is;
	std::ostream& os;
public:
	CommandProcessor(Machine machine, std::istream& is, std::ostream& os) :
		machine(std::move(machine)), is(is), os(os) { }

	void run() {
		std::string command;
		while (std::getline(is, command)) {
			if (command == "end") {
				machine.print(os);
				break;
			} else if (command == "sum") {
				machine.sum();
			} else if (command == "subtract") {
				machine.subtract();
			} else if (command == "concat") {
				machine.concat();
			} else if (command == "discard") {
				machine.discard();
			} else {
				machine.push(std::stoi(command));
			}
		}
	}
};

int main() {
	CommandProcessor({ }, std::cin, std::cout).run();

	return 0;
}