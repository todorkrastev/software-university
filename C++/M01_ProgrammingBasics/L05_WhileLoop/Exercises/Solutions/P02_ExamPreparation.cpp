#include <iostream>
#include <string>
using namespace std;

int main() {

	string input;
	getline(cin, input);
	int numPoorGrades = stoi(input);
	string command;
	getline(cin, command);
	string secondInput;
	int currGrade;
	int counterSubjects = 0;
	string lastSubject = command;
	int counterPoorGrades = 0;
	int totalGrades = 0;

	while (command != "Enough") {
		counterSubjects++;
		getline(cin, secondInput);
		currGrade = stoi(secondInput);
		totalGrades += currGrade;
		lastSubject = command;
		if (currGrade <= 4) {
			counterPoorGrades++;
		}

		if (counterPoorGrades == numPoorGrades) {
			cout << "You need a break, " << numPoorGrades << " poor grades." << endl;

			return 0;
		}

		getline(cin, command);
	}

	cout.setf(ios::fixed);
	cout.precision(2);

	double averageGrade = static_cast<double>(totalGrades) / counterSubjects;

	cout << "Average score: " << averageGrade << endl;
	cout << "Number of problems: " << counterSubjects << endl;
	cout << "Last problem: " << lastSubject << endl;

	return 0;
}
