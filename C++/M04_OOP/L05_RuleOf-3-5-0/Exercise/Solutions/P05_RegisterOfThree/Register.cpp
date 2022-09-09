#include "Register.h"
#include <cstdlib>

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

Register& Register::operator=(const Register& other) {
	if (this != &other) {
		Company* companiesCopy = new Company[other.numAdded];

		for (size_t i = 0; i < other.numAdded; i++) {
			companiesCopy[i] = other.companiesArray[i];
		}

		if (this->companiesArray != nullptr) {
			delete[] this->companiesArray;
		}

		this->companiesArray = companiesCopy;
		this->numAdded = other.numAdded;
	}

	return *this;
}

Register::Register(const Register& other) {
	Company* companiesCopy = new Company[other.numAdded];

	for (size_t i = 0; i < other.numAdded; i++) {
		companiesCopy[i] = other.companiesArray[i];
	}

	this->companiesArray = companiesCopy;
	this->numAdded = other.numAdded;
}