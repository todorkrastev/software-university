#include <iostream> // directly looks for system file iostream
#include "Macros.h" // first looks for local file "01. Macros.h" - if not found, searches for system file

int main() {
	double radius;
	std::cin >> radius;

	std::cout << PI << std::endl;

	SHOW(PI * radius * radius);
#undef SHOW
#define SHOW std::cout << "That's all, folks!" << std::endl;
	SHOW
#undef SHOW
	// The following line won't compile because SHOW is no longer defined
	// SHOW
	return 0;
}
