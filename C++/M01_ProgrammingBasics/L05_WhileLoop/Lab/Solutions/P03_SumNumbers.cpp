#include <iostream>
#include <string>
using namespace std;

int main() {

	int initNum, currNum;
	cin >> initNum >> currNum;

	int sum = 0;
	while (sum < initNum) {
		sum += currNum;
		if (initNum <= sum) {
			cout << sum << endl;
			return 0;
		}
		cin >> currNum;
	}
}
