#include <iostream>
#include <cmath>

using namespace std;

int main() {
	int target = 1000;

	int numDays;
	cin >> numDays;

	double runKm;
	cin >> runKm;

	int goal = 0;
	double total = 0.0;
	double totalKm = 0.0;

	for (int day = 0; day <= numDays; day++) {
		if (day == 0) {
			total += runKm;
		} else {
			cin >> goal;
			total += (total * goal / 100);
		}
		totalKm += total;
	}


	double diff = abs(target - totalKm);

	if (totalKm < target) {
		cout << "Sorry Mrs. Ivanova, you need to run " << ceil(diff) << " more kilometers" << endl;
	} else {
		cout << "You've done a great job running " << ceil(diff) << " more kilometers!" << endl;
	}


	return 0;
}