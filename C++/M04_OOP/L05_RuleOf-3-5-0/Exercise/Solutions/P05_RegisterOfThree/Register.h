#ifndef REGISTER_H
#define REGISTER_H

#include "Company.h"

class Register {
	size_t numAdded;
	Company* companiesArray;
public:
	Register() : numAdded(0), companiesArray(nullptr) {}

	Register(size_t numCompanies);

	void add(const Company& c);

	Company get(int companyId) const;

	~Register();

	Register& operator=(const Register& other);
	Register(const Register& other);
};

#endif // !REGISTER_H

