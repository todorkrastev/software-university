#include <iostream>

#include "Sequence.h"

class IntegersGenerator {
	int last;
public:
	IntegersGenerator() : last(0) {}

	int operator()() {
		return this->last++;
	}
};

class FibonacciGenerator{
	int last;
	int current;
public:
	FibonacciGenerator() : last(0), current(0) {}

	int operator()() {
		if (this->current == 0 && this->last == 0) {
			this->last = 1;
			return 0;
		}

		int next = this->last + this->current;
		this->last = this->current;
		this->current = next;

		return next;
	}
};

template<typename T, typename Generator>
void readGenerateWrite() {
	Sequence<T, Generator> sequence;

	int numToGenerate;
	std::cin >> numToGenerate;
	sequence.generateNext(numToGenerate);

	for (T element : sequence) {
		std::cout << element << " ";
		std::cin >> numToGenerate;
		sequence.generateNext(numToGenerate);
	}
}

int main() {
	char generatorType;
	std::cin >> generatorType;
	if (generatorType == 'i') {
		readGenerateWrite<int, IntegersGenerator>();
	}
	else if (generatorType == 'f') {
		readGenerateWrite<int, FibonacciGenerator>();
	}

	return 0;
}