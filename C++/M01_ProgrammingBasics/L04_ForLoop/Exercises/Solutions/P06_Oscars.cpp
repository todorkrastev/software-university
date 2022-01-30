#include <iostream>
#include <string>

using namespace std;

int main() {
	string name;
	double points;
	int jury;
	getline(cin >> ws, name);
	cin >> points >> jury;

	string currPanelist;
	double pointsPanelist;
	double goal = 1250.5;
	cout.setf(ios::fixed);
	cout.precision(1);
	for (int i = 0; i < jury; i++) {
		getline(cin >> ws, currPanelist);
		cin >> pointsPanelist;

		points += (currPanelist.length() * pointsPanelist) / 2;

		if (goal < points) {
			cout << "Congratulations, " << name << " got a nominee for leading role with " << points << "!" << endl;
			return 0;
		}
	}
	
	cout << "Sorry, " << name << " you need " << goal - points << " more!" << endl;

	return 0;
}
