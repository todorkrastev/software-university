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

	bool operator<(const Fraction& other) const {
		return this->numerator * other.denominator < other.numerator * this->denominator;
	}
};

int main() {
	// NOTE: 1/3 and 2/6 are the same - std::set assumes that 
	// if (a < b) is false and (b < a) is false, then (a == b) is true and will not add 2/6, 
	// because it already has the equivalent value 1/3 in the set
	std::set<Fraction> fractions{ Fraction{1, 3}, Fraction{2, 10}, Fraction{2, 6} };

	for (Fraction f : fractions) {
		std::cout << f.getNumerator() << "/" << f.getDenominator() << std::endl;
	}

	return 0;
}