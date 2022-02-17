#include <string>
#include <iostream>
using namespace std;

int main() {
	string input;
	cin >> input;

	int sumPrime = 0; 
	int sumNonPrime = 0;

	while (input != "stop") {
		int number = stoi(input);

		if (number < 0) {
			cout << "Number is negative." << endl;
		} else {
			int count = 0;
			for (int diff = 1; diff <= number; diff++) {
				if (number % diff == 0) {
					count++;
				}
			}
			if (count == 2) {
				sumPrime += number;
			} else {
				sumNonPrime += number;
			}
		}
		
		cin >> input;
	}

	cout << "Sum of all prime numbers is: " << sumPrime << endl;
	cout << "Sum of all non prime numbers is: " << sumNonPrime << endl;

	return 0;
}
