#include <iostream>
using namespace std;

int main() {

	double sneakers = 0.6;
	double trainingClothes = 0.8;
	double ball = 4;
	double acc = 5;

	int membershipAnnualPrice;
	cin >> membershipAnnualPrice;

	double sneakersPrice = membershipAnnualPrice * sneakers;
	double trainingClothesPrice = sneakersPrice * trainingClothes;
	double ballPrice = trainingClothesPrice / ball;
	double accPrice = ballPrice / acc;

	double equipmentTotalPrice = membershipAnnualPrice + sneakersPrice + trainingClothesPrice + ballPrice + accPrice;

	cout << equipmentTotalPrice << endl;

	return 0;
}
