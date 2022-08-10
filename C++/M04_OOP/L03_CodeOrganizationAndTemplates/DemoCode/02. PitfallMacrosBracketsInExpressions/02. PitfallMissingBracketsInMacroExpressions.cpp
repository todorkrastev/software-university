#include<iostream>
#include<sstream>
using namespace std;

int main() {
	// this definition does not take into account that "value" might be an expression, so will HALF(4 + 2) will become 4 + 2 / 2 == 4 + 1 == 5
#define HALF(value) value / 2
	cout << HALF(4 + 2) << endl;

	// redefine HALF with brackets (and a better "parameter" name) - this time the code will be ((4 + 2) / 2.0) == 3
#define HALF(expression) ((expression) / 2)
	cout << HALF(4 + 2) << endl;

	return 0;
}
