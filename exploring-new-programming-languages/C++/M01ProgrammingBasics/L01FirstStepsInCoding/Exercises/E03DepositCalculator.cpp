

#include <iostream>
using namespace std;

int main()
{
	double deposit;
	cin >> deposit;

	int period;
	cin >> period;

	double annualRate;
	cin >> annualRate;

	double annualInterest = deposit * annualRate / 100;
	double monthlyInterest = annualInterest / 12;
	double interest = deposit + (period * monthlyInterest);


	cout << interest << endl;
	return 0;
}