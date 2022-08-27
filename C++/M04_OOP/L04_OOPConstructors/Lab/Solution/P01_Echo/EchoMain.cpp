#include <iostream>
#include <string>
#include <vector>

using namespace std;

#include "Echo.h"
#include "EmailContact.h"
#include "ContactManagerUI.h"

int main() {
	echoOn = true;

	echo("=== Contact Manager (C) Deluxe Edition ===");

	echo("Hints on? (y/n): ");
	char enableHintsInput = ' ';
	while (enableHintsInput != 'y' && enableHintsInput != 'n') {
		std::cin >> enableHintsInput;
		enableHintsInput = tolower(enableHintsInput);
	}
	echoOn = enableHintsInput == 'y';

	std::vector<EmailContact> contacts;
	ContactManagerUI ui(contacts, echoOn);
	ui.start();

	echo("Thank you for using Contact Manager (C) Deluxe!");

	return 0;
}