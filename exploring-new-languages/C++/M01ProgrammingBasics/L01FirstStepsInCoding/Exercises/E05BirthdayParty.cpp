

#include <iostream>
using namespace std;

int main()
{
	int rentOfTheHall;
	cin >> rentOfTheHall;

	double priceCake = rentOfTheHall * 0.2;
	double beverages = priceCake * 0.55;
	double animator = static_cast<double> (rentOfTheHall) / 3;

	double budgetNeeded = rentOfTheHall + priceCake + beverages + animator;

	cout << budgetNeeded << endl;
	return 0;
}
