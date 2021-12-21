#include <iostream>
using namespace std;

int main() {

	int n;
	cin >> n;

	string output;
	if (n < 100) {
		output = "Less than 100";
	} else if (200 < n) {
		output = "Greater than 200";
	} else {
		output = "Between 100 and 200";
	}

	cout << output << endl;

	return 0;
}
