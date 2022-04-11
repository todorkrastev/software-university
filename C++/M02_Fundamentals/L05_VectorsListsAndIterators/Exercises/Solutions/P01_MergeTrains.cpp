#include <iostream>
#include <list>
#include <sstream>

using namespace std;


void readTrain(list<int>& track) {

	string buf;

	getline(cin, buf);
	istringstream sbuf(buf);
	int car;

	while (sbuf >> car) {
		track.push_front(car);
	}
}

void printTrain(const list<int>& train) {

	for (int car : train) {
		cout << car << ' ';
	}

	cout << endl;

}

int main() {

	list<int> trackA;
	list<int> trackB;
	list<int> merged;
	string mergedInstr;

	readTrain(trackA);
	readTrain(trackB);


	list<int>::iterator itA = trackA.begin();
	list<int>::iterator itB = trackB.begin();

	while (itA != trackA.end() || itB != trackB.end()) {

		if (itA != trackA.end() && itB != trackB.end()) {
			if (*itA < *itB) {
				mergedInstr += 'A';
				merged.push_front(*itA);
				itA++;
			} else {
				mergedInstr += 'B';
				merged.push_front(*itB);
				itB++;
			}
		} else {
			if (itA != trackA.end()) {
				mergedInstr += 'A';
				merged.push_front(*itA);
				itA++;
			} else {
				mergedInstr += 'B';
				merged.push_front(*itB);
				itB++;
			}
		}
	}

	cout << mergedInstr << endl;
	printTrain(merged);

	return 0;
}