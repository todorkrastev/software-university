#include <iostream>
#include <vector>
#include <climits>

using namespace std;


unsigned stringToTime(const string& currTimeStr) {

	unsigned h = (currTimeStr[0] - '0') * 10 + (currTimeStr[1] - '0');
	unsigned m = (currTimeStr[2] - '0') * 10 + (currTimeStr[3] - '0');

	return h * 60 + m;
}

unsigned calcWaitTime(unsigned busArrival, unsigned trainDeparture) {

	unsigned waitTime;

	if (busArrival > trainDeparture) {
		waitTime = (24 * 60 - busArrival) + trainDeparture;
	}
	else {
		waitTime = trainDeparture - busArrival;
	}

	return waitTime;
}


int main() {

	size_t busses;

	cin >> busses;

	vector<unsigned> times(busses);

	for (size_t curr = 0; curr < busses; curr++) {

		string currTimeStr;
		cin >> currTimeStr;

		times[curr] = stringToTime(currTimeStr);
	}

	string trainLeaveStr;
	cin >> trainLeaveStr;

	unsigned trainLeaveTime = stringToTime(trainLeaveStr);

	size_t busIndex;
	unsigned minWaitTime = UINT_MAX;

	for (size_t curr = 0; curr < busses; curr++) {

		unsigned waitTime = calcWaitTime(times[curr], trainLeaveTime);

		if (waitTime < minWaitTime) {
			minWaitTime = waitTime;
			busIndex = curr;
		}

	}

	cout << busIndex + 1 << endl;

	return 0;
}