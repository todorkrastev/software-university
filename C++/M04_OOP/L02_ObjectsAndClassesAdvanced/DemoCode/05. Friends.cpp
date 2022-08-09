#include <iostream>
#include <istream>
#include <string>

class Company {
private:
	std::string id;
	long long capitalDollars;

public:
	Company() {}

	Company(std::string id, long long capitalDollars)
		: id(id)
		, capitalDollars(capitalDollars) {
	}

	void print() {
		std::cout << this->id << " (" << this->capitalDollars << ")" << std::endl;
	}

	friend void getCompany(std::istream& in, Company& c);
};

// NOTE: it's actually good practice to define such parsing functions as members of the parsed class, but we're doing it this way to ease the transition to operator overloading later
void getCompany(std::istream& in, Company& c) {
	in >> c.id >> c.capitalDollars;
}

int main() {
	Company c;
	// NOTE: does this look familiar to getline(cin, s)?
	getCompany(std::cin, c);
	c.print();

	return 0;
}