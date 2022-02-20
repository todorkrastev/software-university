#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {
	int numDay, foodQuantity;
	cin >> numDay >> foodQuantity;

	double firstDeerFood, secondDeerFood, thirdDeerFood;
	cin >> firstDeerFood >> secondDeerFood >> thirdDeerFood;

	double firstDeer = numDay * firstDeerFood;
	double secondDeer = numDay * secondDeerFood;
	double thirdDeer = numDay * thirdDeerFood;

	double totalFood = firstDeer + secondDeer + thirdDeer;
	double diff = abs(totalFood - foodQuantity);

	if (totalFood <= foodQuantity) {
		cout << floor(diff) << " kilos of food left." << endl;
	} else {
		cout << ceil(diff) << " more kilos of food are needed." << endl;
	}


	return 0;
}