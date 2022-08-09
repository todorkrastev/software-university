#include <iostream>
#include <set>

class Fraction {
	int numerator;
	int denominator;

public:
	Fraction(int num, int denom) : numerator(num), denominator(denom) {}

	int getNumerator() {
		return this->numerator;
	}

	int getDenominator() {
		return this->denominator;
	}

	bool operator<(Fraction& other) { // lack of const parameter and const on the method will cause a compilation error below when creating a set<Fraction>
		return this->numerator * other.denominator < other.numerator * this->denominator;
	}
};

int main() {
	std::set<Fraction> fractions{ Fraction{ 1, 3 }, Fraction{ 2, 10 }, Fraction{ 2, 6 } };

	for (Fraction f : fractions) {
		std::cout << f.getNumerator() << "/" << f.getDenominator() << std::endl;
	}

	return 0;
}
