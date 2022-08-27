#include "ContactManagerUI.h"

ContactManagerUI::ContactManagerUI(std::vector<EmailContact>& contacts, bool hintsOn)
	: contacts(contacts)
	, running(false) {
	echoOn = hintsOn;
}

void ContactManagerUI::start() {
	this->running = true;
	while (running) {
		printMenu();

		char choice;
		std::cin >> choice;
		handleInput(choice);
	}
}

void ContactManagerUI::stop() {
	this->running = false;
}

void ContactManagerUI::handleInput(char choice) {
	if (choice == '1') {
		echo("Enter contact name and email:");
		std::string name, email;
		std::cin >> name >> email;
		this->contacts.push_back(EmailContact(name, email));
	}
	else if (choice == '2') {
		auto contactIterator = queryContact();

		if (contactIterator != this->contacts.end()) {
			echo(std::string("... removed ") + (std::string)*contactIterator);
		}
		else {
			echo("... no such contact");
		}
	}
	else if (choice == '3') {
		auto contactIterator = queryContact();

		if (contactIterator != this->contacts.end()) {
			std::cout << *contactIterator << std::endl;
		}
		else {
			echo("... no such contact");
		}
	}
	else if (choice == '4') {
		echoOn = !echoOn;
	}
	else if (choice == 'e') {
		echo("Exiting...");
		this->stop();
	}
	else {
		echo("... incorrect input, try again");
	}
}

void ContactManagerUI::printMenu() {
	echo("--- Menu ---");
	echo("1. Add contact");
	echo("2. Remove contact");
	echo("3. Print contact");
	echo("4. Toggle hints off/on");
	echo("e. Exit");
	echo("Please enter a choice (1, 2, 3, or Q): ");
}

std::vector<EmailContact>::iterator ContactManagerUI::queryContact() {
	echo("Enter the name or email of a contact:");
	std::string nameOrEmail;
	std::cin >> nameOrEmail;

	return std::find_if(this->contacts.begin(), this->contacts.end(),
		[&](const EmailContact& e) { return e.getName() == nameOrEmail || e.getEmail() == nameOrEmail; });
}