#include <iostream>
#include <string>
using namespace std;

int main() {

	string day;
	cin >> day;

	string output;
	if (day == "Monday" || day == "Tuesday" || day == "Friday") {
		output = "12";
	} else if (day == "Wednesday" || day == "Thursday") {
		output = "14";
	} else if (day == "Saturday" || day == "Sunday") {
		output = "16";
	}

	cout << output << endl;

	return 0;
}
