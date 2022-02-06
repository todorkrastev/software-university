#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main() {
	int a, b;
	cin >> a >> b;

	int total = a * b;
	for (; ; ) {
		string n;
		cin >> n;
		if (n == "STOP") {
			cout << total << " pieces are left." << endl;
			break;
		}
		else {
			int left = stoi(n);
			total -= left;
			if (total <= 0) {
				cout << "No more cake left! You need " << abs(total) << " pieces more." << endl;
				break;
			}
		}
	}

	return 0;
}
