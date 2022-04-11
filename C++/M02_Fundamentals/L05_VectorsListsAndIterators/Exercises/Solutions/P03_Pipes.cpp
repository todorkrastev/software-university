#include <iostream>
#include <vector>
#include <sstream>

using namespace std;


int main() {

	unsigned pipes;
	vector<unsigned> checkup;
	vector<unsigned> installation;

	cin >> pipes;
	checkup.resize(pipes);
	installation.resize(pipes);

	unsigned curr;
	for (curr = 0; curr < pipes; curr++) {
		cin >> checkup[curr];
	}
	for (curr = 0; curr < pipes; curr++) {
		cin >> installation[curr];
	}

	for (curr = 0; curr < pipes; curr++) {

		unsigned amortization = installation[curr] - checkup[curr];

		unsigned lifetime = installation[curr] / amortization;

		cout << lifetime << " ";

	}

	cout << endl;


	return 0;
}