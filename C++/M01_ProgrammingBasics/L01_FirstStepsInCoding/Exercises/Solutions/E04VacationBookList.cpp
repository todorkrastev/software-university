#include <iostream>
using namespace std;

int main()
{
	int numPages;
	cin >> numPages;

	int pagePerHour;
	cin >> pagePerHour;

	int days;
	cin >> days;

	int timeNeeded = numPages / pagePerHour;
	int hoursPerDay = timeNeeded / days;

	cout << hoursPerDay << endl;
	return 0;
}
