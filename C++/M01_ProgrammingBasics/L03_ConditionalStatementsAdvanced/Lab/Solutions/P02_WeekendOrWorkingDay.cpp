#include <iostream>
#include <string>
using namespace std;

int main() {

	string day;
	cin >> day;

	string output;
	if (day == "Monday" || day == "Tuesday" || day == "Wednesday" || day == "Thursday" || day == "Friday") {
		output = "Working day";
	} else if (day == "Saturday" || day == "Sunday") {
		output = "Weekend";
	} else {
		output = "Error";
	}

	cout << output << endl;

	return 0;
}
