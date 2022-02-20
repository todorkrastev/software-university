#include <iostream>
using namespace std;

int main() {
	double budget;
	cin >> budget;

	string destination, season;
	cin >> destination >> season;

	int days;
	cin >> days;

	double pricePerDay = 0;

	if (season == "Winter") {
		if (destination == "Dubai") {
			pricePerDay = 45000;
		} else if (destination == "Sofia") {
			pricePerDay = 17000;
		} else if (destination == "London")
		{
			pricePerDay = 24000;
		}
	} else if (season == "Summer") {
		if (destination == "Dubai") {
			pricePerDay = 40000;
		} else if (destination == "Sofia") {
			pricePerDay = 12500;
		} else if (destination == "London") {
			pricePerDay = 20250;
		}
	}

	double totalSum = days * pricePerDay;

	if (destination == "Dubai") {
		totalSum = totalSum - 0.30 * totalSum;
	} else if (destination == "Sofia") {
		totalSum = totalSum + 0.25 * totalSum; 
	}


	cout.setf(ios::fixed);
	cout.precision(2);

	if (budget >= totalSum) {
		cout << "The budget for the movie is enough! We have " << budget - totalSum << " leva left!";
	} else {
		cout << "The director needs " << totalSum - budget << " leva more!";
	}

	return 0;
}