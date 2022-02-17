#include <iostream>

using namespace std;

int main() {
	for (int first = 1; first <= 10; first++) {
		for (int second = 1; second <= 10; second++) {
			cout << first << " * " << second << " = " << first * second << endl;
		}
	}
}