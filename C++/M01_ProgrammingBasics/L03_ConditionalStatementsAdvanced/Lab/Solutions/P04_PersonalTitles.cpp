#include <iostream>
#include <string>
using namespace std;

int main() {

	double age;
	char gender;
	cin >> age >> gender;

	string output;
	switch (gender) {
	case 'm':
		if (16 <= age) {
			output = "Mr.";
		}
		else {
			output = "Master";
		}
		break;
	case 'f':
		if (16 <= age) {
			output = "Ms.";
		} else {
			output = "Miss";
		}
		break;
	default:
		output = "Invalid output!";
		break;
	}

	cout << output << endl;

	return 0;
}
