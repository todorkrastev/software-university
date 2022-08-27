#include "EmailContact.h"

#include <sstream>

EmailContact::EmailContact(std::string name, std::string email) : name(name), email(email) {}

std::string EmailContact::getName() const {
	return this->name;
}

std::string EmailContact::getEmail() const {
	return this->email;
}

std::ostream& operator<<(std::ostream& out, const EmailContact& e) {
	return out << e.getName() << " " << e.getEmail();
}

EmailContact::operator std::string() const {
	std::ostringstream out;
	out << *this;
	return out.str();
}