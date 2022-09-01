#ifndef COMPANY_H
#define COMPANY_H

#include <string>
#include <ostream>
#include <istream>
#include <vector>
#include <utility>

class Company {
private:
	int id;
	std::string name;

public:
	Company() {}

	Company(int id, std::string name)
		: id(id)
		, name(name) {}

	int getId() const {
		return this->id;
	}

	std::string getName() const {
		return this->name;
	}

	friend std::istream& operator>>(std::istream& in, Company& company);
	friend std::ostream& operator<<(std::ostream& out, const Company& company);
};

#endif // !COMPANY_H