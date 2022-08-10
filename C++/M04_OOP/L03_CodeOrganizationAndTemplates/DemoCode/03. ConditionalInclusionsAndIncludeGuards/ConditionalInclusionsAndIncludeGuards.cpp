#include<iostream>
#include<cstdlib>

// NOTE: without the header guards, we would get a compilation error, because HeaderGuardedFile defines a function, and OtherFileAlsoIncludingHeaderGuardedFile included HeaderGuardedFile, so the function would appear twice
#include "HeaderGuardedFile.h"
#include "OtherFileAlsoIncludingHeaderGuardedFile.h"

using namespace std;

void clearScreen() {
	// NOTE: this demo does not intend to show the best way to clear the console in a multi-platform way, but simply to demonstrate the usage of ifdef
#ifdef _WIN32
	system("cls");
#else
	system("clear");
#endif
}

#define PRECISION 2
// NOTE: uncomment one of the lines below and the calculations will be done with float/int
//#define PRECISION 1
//#define PRECISION 0

int main() {
	cout << "some text that will be cleared immediately" << endl;
	clearScreen();

#if PRECISION == 2
#define PI 3.14159265359
	typedef double Number;
#elif PRECISION == 1
#define PI 3.14
	typedef float Number;
#else
#define PI 3
	typedef int Number;
#endif

	Number radius;
	cin >> radius;
	cout << radius * radius * PI << endl;

	return 0;
}
