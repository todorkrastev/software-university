#include <iostream>

using namespace std;

int main() {
	int numOfClimbers, group;
	cin >> numOfClimbers;

	int musala = 0;
	int montBlanc = 0;
	int kilimanjaro = 0;
	int k2 = 0;
	int everest = 0;

	int totalPeople = 0;
	for (int i = 0; i < numOfClimbers; i++) {
		cin >> group;
		totalPeople += group;

		if (0 <= group && group <= 5) {
			musala += group;
		} else if (6 <= group && group <= 12) {
			montBlanc += group;
		} else if (13 <= group && group <= 25) {
			kilimanjaro += group;
		} else if (26 <= group && group <= 40) {
			k2 += group;
		} else {
			everest += group;
		}
	}

	cout.setf(ios::fixed);
	cout.precision(2);

	cout << static_cast<double>(musala) / totalPeople * 100 << "%" << endl;
	cout << static_cast<double>(montBlanc) / totalPeople * 100 << "%" << endl;
	cout << static_cast<double>(kilimanjaro) / totalPeople * 100 << "%" << endl;
	cout << static_cast<double>(k2) / totalPeople * 100 << "%" << endl;
	cout << static_cast<double>(everest) / totalPeople * 100 << "%" << endl;

	return 0;
} 
