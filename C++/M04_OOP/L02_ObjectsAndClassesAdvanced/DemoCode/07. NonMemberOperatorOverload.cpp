#include <iostream>
#include <string>
#include <sstream>

class Price {
	int cents;
	std::string currency;
public:
	Price() {}

	Price(int cents, std::string currency) : cents(cents), currency(currency) {}

	int getCents() const {
		return this->cents;
	}

	std::string getCurrency() const {
		return this->currency;
	}

	friend std::istream& operator>>(std::istream& in, Price& p);
};

Price operator+(const Price& a, const Price& b) {
	std::string resultCurrency = a.getCurrency();
	if (a.getCurrency() != b.getCurrency()) {
		resultCurrency = "[invalid]";
	}

	return Price(a.getCents() + b.getCents(), resultCurrency);
}

std::ostream& operator<<(std::ostream& out, const Price& p) {
	return out << p.getCents() << " " << p.getCurrency();
}

std::istream& operator>>(std::istream& in, Price& p) {
	return in >> p.cents >> p.currency;
}

std::string operator+(const std::string& s, const Price& p) {
	std::ostringstream out;
	out << s << p.getCents() << " " << p.getCurrency();
	return out.str();
}

int main() {
	Price a, b;
	std::cin >> a >> b;

	Price sum = a + b;
	std::cout << sum << std::endl;

	return 0;
}