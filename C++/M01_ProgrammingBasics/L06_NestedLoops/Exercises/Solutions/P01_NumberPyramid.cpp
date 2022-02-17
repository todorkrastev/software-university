#include <iostream>
#include<string>
using namespace std;

int main() {
	int number;
	cin >> number;
	int count = 1;
	bool flag = false;
	for (int row = 1; row <= number; row++) {
		for (int col = 1; col <= row; col++) {
			cout << count++ << " ";
			if (count > number) {
				flag = true;
				break;
			}
		}
		cout << endl;
		if (flag) {
			break;
		}
	}
}