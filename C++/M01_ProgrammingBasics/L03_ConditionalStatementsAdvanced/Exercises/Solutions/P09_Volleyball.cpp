#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int main() {

    string year;
    int holidays, weekendsHome;
    cin >> year >> holidays >> weekendsHome;

    int weekendsPerYear = 48;

    double playHolidays = holidays * (2.0 / 3.0);
    double playWeekendsSofia = (weekendsPerYear - weekendsHome) * (3.0 / 4.0);
    double playInTotal = floor(playWeekendsSofia + weekendsHome + playHolidays);
    double playInTotalLeap = floor((playWeekendsSofia + weekendsHome + playHolidays) * 1.15);

    if (year == "leap") {
        cout << playInTotalLeap << endl;
    } else if (year == "normal") {
        cout << playInTotal << endl;
    }

	return 0;
}
