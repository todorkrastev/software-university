#include <iostream>
#include <algorithm>
using namespace std;

int main() {

	int n;
	cin >> n;
	int minNum = INT16_MAX;
	int input;
	for (int i = 0; i < n; i++) {
		cin >> input;
		minNum = min(minNum, input);
	}

	cout << minNum << endl;

	return 0;
}
