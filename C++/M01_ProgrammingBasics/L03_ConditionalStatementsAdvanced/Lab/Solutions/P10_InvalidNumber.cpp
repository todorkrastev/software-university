#include <iostream>
using namespace std;

int main() {

	int n;
	cin >> n;

	if ((n != 0 && n < 100) || 200 < n) {
		cout << "invalid" << endl;
	}

	return 0;
}
