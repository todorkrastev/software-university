#include <iostream>
#include <string>

class Company {
private:
	long long capitalDollars;
public:
	const std::string id;

	Company(std::string id, long long capitalDollars) : id(id), capitalDollars(capitalDollars) {}

	void addCapital(long long dollars) {
		this->capitalDollars += dollars;
	}

	void print() const {
		std::cout << this->id << this->capitalDollars << std::endl;
	}
};

int main() {
	Company c{ "GOOGINC.", 100000000LL };
	const Company& constRef = c;
	
	std::cout << c.id << std::endl;
	//c.id = "thiswontcompile"; // compilation error - attempting to modfy a const field

	constRef.print();
	c.addCapital(999999);
	//constRef.addCapital(999999); // compilation error - calling non-const method on const reference

	return 0;
}