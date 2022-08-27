#ifndef CONTACT_MANAGER_UI_H
#define CONTACT_MANAGER_UI_H

#include <vector>
#include "EmailContact.h"
#include "Echo.h"
#include <algorithm>
#include <sstream>

class ContactManagerUI {
	std::vector<EmailContact>& contacts;
	bool running;
public:
	ContactManagerUI(std::vector<EmailContact>& contacts, bool hintsOn);

	void start();

	void stop();

private:
	void handleInput(char choice);

	void printMenu();

	std::vector<EmailContact>::iterator queryContact();
};

#endif // !CONTACT_MANAGER_UI_H

