#include <iostream>
#include <cstring>

const size_t N = 512;


int main() {

	char* buffer = new char[N];
	size_t curr = 0;

	std::cin.get(buffer, N);

	size_t len = strlen(buffer);

	for (size_t idx = 0; idx < len; idx++) {
		buffer[idx] = tolower(buffer[idx]);
	}

	std::cout << buffer << std::endl;

	for (size_t idx = 0; idx < len; idx++) {
		buffer[idx] = toupper(buffer[idx]);
	}

	std::cout << buffer << std::endl;

	delete[] buffer;

	return 0;
}

// -----------------------------------------------------------------------------------------------

// Second Option

// -----------------------------------------------------------------------------------------------

#include <iostream>
#include <cstring>

const size_t N = 512;

void do_and_print(char* buffer, size_t len, int (*f)(int)) {

	for (size_t idx = 0; idx < len; idx++) {
		buffer[idx] = f(buffer[idx]);
	}

	std::cout << buffer << std::endl;
}

int main() {

	char* buffer = new char[N];
	size_t curr = 0;

	std::cin.get(buffer, N);

	size_t len = strlen(buffer);

	do_and_print(buffer, len, tolower);
	do_and_print(buffer, len, toupper);

	delete[] buffer;

	return 0;
}