#include <iostream>
#include <string>
using namespace std;

int main() {

	string name, grade;
	cin >> name >> grade;

	int counter = 1;
	double currGrade = stod(grade);
	double avgGrade = currGrade;
	double sum = currGrade;
	while (4 <= avgGrade) {
		cin >> grade;
		currGrade = stod(grade);
		sum += currGrade;
		counter++;

		if (currGrade < 4) {
			break;
		}

		avgGrade = sum / counter;

		if (counter == 12) {
			cout.setf(ios::fixed);
			cout.precision(2);
			cout << name << " graduated. Average grade: " << avgGrade << endl;

			return 0;
		}
	}

	cout << name << " has been excluded at " << counter << " grade" << endl;

	return 0;
}
