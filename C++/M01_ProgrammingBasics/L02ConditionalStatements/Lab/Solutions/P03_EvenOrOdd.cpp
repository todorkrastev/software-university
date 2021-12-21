#include <iostream>
using namespace std;

int main() {

	int n;
	cin >> n;

	string output = n % 2 == 0 ? "even" : "odd";

	cout << output << endl;

	return 0;
}
