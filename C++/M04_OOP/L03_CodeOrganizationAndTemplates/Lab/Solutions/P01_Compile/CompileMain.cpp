#include "Defines.h"

int main() {
#ifndef DONT_COMPILE_THIS
	this here has compilation errors :)
#endif // !DONT_COMPILE_THIS
	using STANDARD_TEMPLATE_LIBRARY;
	string input;
	cin >> input;
	cout << input << endl;

	return 0;
}