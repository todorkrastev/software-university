#include <iostream>
#include <cstdlib>
#include <string>

class Company {
public:
	static const int ID_LENGTH = 8;
	static int CREATED_COMPANIES;

private:
	std::string id;
	long long capitalDollars;

public:
	Company(std::string id, long long capitalDollars) 
		: id(isValidId(id) ? id : "[invalid]")
		, capitalDollars(capitalDollars) {
		CREATED_COMPANIES++;
	}

	void print() {
		std::cout << this->id << " (" << this->capitalDollars << ")" << std::endl;
	}

	bool isValidId(std::string id) {
		return id.size() == ID_LENGTH;
	}

	static std::string generateId() {
		std::string id(ID_LENGTH, ' ');

		for (int i = 0; i < ID_LENGTH; i++) {
			id[i] = 'A' + rand() % (1 + 'Z' - 'A');
		}

		return id;
	}

	static Company& maxByCapital(Company& a, Company& b) {
		if (a.capitalDollars >= b.capitalDollars) {
			return a;
		}
		else {
			return b;
		}
	}
};

int Company::CREATED_COMPANIES = 0;

int main() {
	Company a{ Company::generateId(), 100 };
	Company b{ "AMAZNINC", 502600000000LL };
	Company c{ "THISIDISTOOLONG", 50 };

	a.print();
	c.print();

	Company::maxByCapital(a, b).print();

	std::cout << Company::CREATED_COMPANIES << std::endl;

	return 0;
}