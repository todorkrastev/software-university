#include "Company.h"

#include <exception>

Company::Company() {}

Company::Company(int id, std::string name, std::vector<std::pair<char, char> > employees)
	: id(id)
	, name(name)
	, employees(employees) {}

int Company::getId() const {
	return this->id;
}

std::string Company::getName() const {
	return this->name;
}

std::vector<std::pair<char, char> > Company::getEmployees() const {
	return this->employees;
}

std::string Company::getInfo() const {
	std::ostringstream info;

	info << *this;

	return info.str();
}

std::ostream& operator<<(std::ostream& stream, const Company& c) {
	stream << c.id << " " << c.name << " (";

	for (int i = 0; i < c.employees.size(); i++) {
		auto initials = c.employees[i];
		stream << initials.first << "." << initials.second << ".";
		if (i < c.employees.size() - 1) {
			stream << ",";
		}
	}

	stream << ")";

	return stream;
}

std::istream& operator>>(std::istream& stream, Company& c) {
	stream >> c.id;
	if (!stream) {
		// couldn't start the read, return the stream in its current error state without attempting further reads
		return stream;
	}

	stream >> c.name;

	std::vector<std::pair<char, char> > employees;
	char current;
	stream >> current; //read the '('

	while (current != ')') {
		char firstInitial, secondInitial;
		stream >> current;
		if (current == ')') {
			if (!employees.empty()) { // sanity check
				throw std::exception();
			}
			break;
		}
		firstInitial = current;

		stream >> current; // read the '.'
		if (current != '.') { // sanity check
			throw std::exception();
		}

		stream >> current;
		secondInitial = current;

		stream >> current; // read the '.'
		if (current != '.') { // sanity check
			throw std::exception();
		}

		stream >> current; // read the ',' or if the input is ending - the ')'
		if (current != ',' && current != ')') { // sanity check
			throw std::exception();
		}

		employees.push_back(std::pair<char, char>{ firstInitial, secondInitial });
	}

	c.employees = employees;

	return stream;
}