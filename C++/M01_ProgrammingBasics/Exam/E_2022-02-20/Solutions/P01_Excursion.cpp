#include <iostream>

using namespace std;

int main() {
	double accomodationPrice = 20;
	double busPrice = 1.6;
	double museumPrice = 6;

	int numPeople, numNigthst, numBus, numMuseum;
	cin >> numPeople >> numNigthst >> numBus >> numMuseum;

	double totalNights = numNigthst * accomodationPrice;
	double totalBus = numBus * busPrice;
	double totalMuseum = numMuseum * museumPrice;

	double totalPerPerson = totalNights + totalBus + totalMuseum;

	double totalPriceForGroup = totalPerPerson * numPeople;

	double totalPrice = totalPriceForGroup * 1.25;


	cout.setf(ios::fixed);
	cout.precision(2);

	cout << totalPrice << endl;
	
	return 0;
}