#include "Register.h"

Register::Register(size_t numCompanies) : companiesArray(new Company[numCompanies]), numAdded(0) {}

void Register::add(const Company& c) {
	this->companiesArray[this->numAdded] = c;
	this->numAdded++;
}

Company Register::get(int companyId) const {
	for (size_t i = 0; i < this->numAdded; i++) {
		if (this->companiesArray[i].getId() == companyId) {
			return this->companiesArray[i];
		}
	}

	// NOTE: this code should never be reached if the input is correct
	return Company();
}

Register::~Register() {
	delete[] this->companiesArray;
}