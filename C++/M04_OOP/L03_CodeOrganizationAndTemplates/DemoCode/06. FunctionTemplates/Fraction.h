#ifndef FRACTION_H
#define FRACTION_H

#include <ostream>
#include <cmath>
#include <string>

class Fraction {
	int numerator;
	int denominator;

public:
	Fraction(int num, int denom) {
		int gcd = greatestCommonDivisor(num, denom);
		this->numerator = num / gcd;
		this->denominator = denom / gcd;
	}

	int getNumerator() const {
		return this->numerator;
	}

	int getDenominator() const {
		return this->denominator;
	}

	bool operator<(const Fraction& other) const {
		return this->numerator * other.denominator < other.numerator * this->denominator;
	}

	Fraction operator*(const int& multiplier) const {
		return Fraction(this->numerator * multiplier, this->denominator);
	}

	Fraction operator*(const Fraction& other) const {
		return Fraction(this->numerator * other.numerator, this->denominator * other.denominator);
	}

	Fraction operator/(const Fraction& other) const {
		// NOTE: diving by a fraction is the same as multiplying by its reciprocal fraction
		return (*this) * Fraction(other.denominator, other.numerator);
	}

private:
	static int greatestCommonDivisor(int a, int b) {
		a = std::abs(a);
		b = std::abs(b);
		while (a != b) {
			if (a < b) {
				b = b - a;
			}
			else {
				a = a - b;
			}
		}

		return a;
	}
};

std::ostream& operator<<(std::ostream& stream, const Fraction& f) {
	stream << f.getNumerator();
	if (f.getDenominator() != 1) {
		stream << "/" << f.getDenominator();
	}

	return stream;
}

#endif // !FRACTION_H
