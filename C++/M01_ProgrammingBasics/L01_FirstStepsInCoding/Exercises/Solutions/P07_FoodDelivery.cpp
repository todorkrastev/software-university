#include <iostream>
using namespace std;

int main() {

	double chickenMenu = 10.35;
	double fishMenu = 12.4;
	double vegetarianMenu = 8.15;
	double dessert = 0.2;
	double delivery = 2.5;

	int chicken, fish, vegetarian;
	cin >> chicken >> fish >> vegetarian;

	double foodTotalPrice = chickenMenu * chicken + fishMenu * fish + vegetarianMenu * vegetarian;
	double dessertPrice = foodTotalPrice * dessert;

	double totalPrice = foodTotalPrice + dessertPrice + delivery;

	cout << totalPrice << endl;


	return 0;
}
