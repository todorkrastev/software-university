#include <iostream>
#include <string>
#include <algorithm>
#include <iomanip>
using namespace std;

int main() {

	int examHour, examMinute, arrivalHour, arrivalMinute;
	cin >> examHour >> examMinute >> arrivalHour >> arrivalMinute;

	int exam = examHour * 60 + examMinute;
	int arrival = arrivalHour * 60 + arrivalMinute;

	int diff = abs(exam - arrival);
	if (exam < arrival) {
		cout << "Late" << endl;
		if (60 <= diff) {
			cout << diff / 60 << ":" << setw(2) << setfill('0') << diff % 60 << " hours after the start" << endl;
		}
		cout << diff << " minutes after the start" << endl;

	} else if (arrival <= exam && 0 <= diff && diff <= 30) {
		cout << "On time" << endl;
		if (diff != 0) {
			cout << diff << " minutes before the start" << endl;
		}
	} else if (arrival <= exam && 30 < diff) {
		cout << "Early" << endl;
		if (60 <= diff) {
			cout << diff / 60 << ":" << setw(2) << setfill('0') << diff % 60 << " hours before the start" << endl;
		}
		cout << diff << " minutes before the start" << endl;
	}

	return 0;
}
