#ifndef COMPANY_H
#define COMPANY_H

#include <istream>
#include <ostream>
#include <string>
#include <sstream>
#include <vector>
#include <utility>

#include "HasId.h"
#include "HasInfo.h"

typedef unsigned char byte;

class Company : public HasId, public HasInfo {
private:
	int id;
	std::string name;
	std::vector<std::pair<char, char> > employees;

public:
	Company();

	Company(int id, std::string name, std::vector<std::pair<char, char> > employees);

	int getId() const;

	std::string getName() const;

	std::vector<std::pair<char, char> > getEmployees() const;

	friend std::ostream& operator<<(std::ostream& stream, const Company& c);
	friend std::istream& operator>>(std::istream& stream, Company& c);

	std::string getInfo() const;
};

#endif // !COMPANY_H
