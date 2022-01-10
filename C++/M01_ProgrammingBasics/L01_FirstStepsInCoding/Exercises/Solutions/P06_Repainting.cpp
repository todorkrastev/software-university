#include <iostream>
using namespace std;

int main() {

	double protectorPricePSM = 1.5;
	double paintPrice = 14.5;
	double thinnerPrice = 5;
	double extraProtector = 2;
	double extraPainting = 1.1;
	double bagPrice = 0.4;
	double labourPrice = 0.3;

	int protector, paint, thinner, hours;
	cin >> protector >> paint >> thinner >> hours;

	double protectorTP = (protector + extraProtector) * protectorPricePSM;
	double paintTP = (paint * extraPainting) * paintPrice;
	double thinnerTP = thinner * thinnerPrice;

	double operatingCosts = protectorTP + paintTP + thinnerTP + bagPrice;
	double labourCosts = labourPrice * operatingCosts * hours;

	double totalPrice = operatingCosts + labourCosts;

	cout << totalPrice << endl;


	return 0;
}
