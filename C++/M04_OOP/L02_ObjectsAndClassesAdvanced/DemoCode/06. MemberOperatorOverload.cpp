#include <iostream>
#include <string>

class Price {
	int cents;
	std::string currency;
public:
	Price(int cents, std::string currency) : cents(cents), currency(currency) {}

	Price operator+(const Price& other) const {
		std::string resultCurrency = this->currency;
		if (this->currency != other.currency) {
			resultCurrency = "[invalid]";
		}

		return Price(this->cents + other.cents, resultCurrency);
	}

	int getCents() const {
		return this->cents;
	}

	std::string getCurrency() const {
		return this->currency;
	}
};

int main() {
	Price a{ 499, "usd" };
	Price b{ 999, "usd" };

	Price sum = a + b;

	std::cout << sum.getCents() << " " << sum.getCurrency() << std::endl;

	return 0;
}