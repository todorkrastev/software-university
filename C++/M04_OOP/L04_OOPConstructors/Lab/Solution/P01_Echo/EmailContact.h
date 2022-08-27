#ifndef EMAIL_CONTACT_H
#define EMAIL_CONTACT_H

#include <string>
#include <ostream>

class EmailContact {
	std::string name;
	std::string email;
public:
	EmailContact(std::string name, std::string email);

	operator std::string() const;

	std::string getName() const;

	std::string getEmail() const;
};

std::ostream& operator<<(std::ostream& out, const EmailContact& e);

#endif // !EMAIL_CONTACT_H

