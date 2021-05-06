

#include <iostream>
using namespace std;

int main()
{
	int input;
	cin >> input;

	double usd = 1.79549;

	double usdToBgn = input * usd;

	cout.setf(ios::fixed);
	cout.precision(2);

	cout << usdToBgn << endl;
	return 0;
}
