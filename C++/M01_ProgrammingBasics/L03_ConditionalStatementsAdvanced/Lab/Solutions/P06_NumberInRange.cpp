#include <iostream>
#include <string>
using namespace std;

int main() {

	int n;
	cin >> n;

	string output;
	if (-100 <= n && n <= 100 && n != 0) {
		output = "Yes";
	} else {
		output = "No";
	}

	cout << output << endl;

	return 0;
}
