#ifndef COMPANY_H
#define COMPANY_H

#include <string>
#include <vector>

class Company {
private:
	int id;
	std::string name;
	std::vector<std::pair<char, char> > employees;

public:
	Company(int id, std::string name, std::vector<std::pair<char, char> > employees);

	int getId() const;

	std::string getName() const;

	std::vector<std::pair<char, char> > getEmployees() const;

	std::string toString() const;

	bool operator==(const Company& other) const;

	std::string operator+(const std::string& s);

	Company& operator+=(const std::pair<char, char>& employee);
};

#endif // !COMPANY_H