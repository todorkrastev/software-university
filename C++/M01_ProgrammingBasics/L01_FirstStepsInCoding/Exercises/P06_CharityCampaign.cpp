#include <iostream>

using namespace std;

int main() {
	double cakePrice = 45;
	double wafflePrice = 5.8;
	double pancakesPrice = 3.20;
	int expenses = 8;

	int totalDays, totalConfectioner, totalCakes, totalWaffles, totalPancakes;

	cin >> totalDays >> totalConfectioner >> totalCakes >> totalWaffles >> totalPancakes;

	double incomeCakes = cakePrice * totalCakes;
	double incomeWaffles = wafflePrice * totalWaffles;
	double incomePancakes = pancakesPrice * totalPancakes;

	double incomePerDay = (incomeCakes + incomeWaffles + incomePancakes) * totalConfectioner;
	double totalIncomeCampaign = incomePerDay * totalDays;
	double profit = totalIncomeCampaign - (totalIncomeCampaign / expenses);

	cout.setf(ios::fixed);
	cout.precision(2);

	cout << profit << endl;

	return 0;
}