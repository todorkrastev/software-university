#include <iostream>
#include <iomanip>
using namespace std;

int main() {

	int hours, minutes;
	cin >> hours >> minutes;

	int additionalTime = 15;
	int totalTime = hours * 60 + minutes + additionalTime;

	int hoursToPrint = totalTime / 60;
	int minutesToPrint = totalTime % 60;

	if (24 <= hoursToPrint) {
		hoursToPrint -= 24;
		cout << hoursToPrint << ":" << setw(2) << setfill('0') << minutesToPrint << endl;
	} else {
		cout << hoursToPrint << ":" << setw(2) << setfill('0') << minutesToPrint << endl;
	}

	return 0;
}
