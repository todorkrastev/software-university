#include <iostream>
#include <string>
using namespace std;

int main() {

	int time;
	string day;
	cin >> time >> day;

	string output;
	if (day == "Sunday" || time < 10 || 18 < time) {
		output = "closed";
	} else {
		output = "open";
	}

	cout << output << endl;

	return 0;
}
