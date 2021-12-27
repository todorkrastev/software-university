#include <iostream>
using namespace std;

int main() {

	int n;
	cin >> n;

	int sequence = 1;
	while (sequence <= n) {
		cout << sequence << endl;
		sequence = sequence * 2 + 1;
	}

	return 0;
}
