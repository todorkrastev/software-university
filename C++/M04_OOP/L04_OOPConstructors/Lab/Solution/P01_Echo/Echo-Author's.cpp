#include "Echo.h"

bool echoOn = false;

void echo(std::string message) {
	if (echoOn) {
		std::cout << message << std::endl;
	}
}