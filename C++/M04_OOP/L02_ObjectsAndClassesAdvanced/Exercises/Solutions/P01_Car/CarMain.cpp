#include <iostream>

#include "Car.h"

// Function that call Print of all Getters
void PrintInfo(const Car& objCar) {
	std::cout << "Brand -> " << objCar.GetBrand() << std::endl;
	std::cout << "Model -> " << objCar.GetModel() << std::endl;
	std::cout << "Year -> " << objCar.GetYear() << std::endl;
}

int main() {
	std::string sBrand;
	std::string sModel;
	int nYear;

	std::cin >> sBrand >> sModel >> nYear;

	const Car objCar(sBrand, sModel, nYear);

	PrintInfo(objCar);

	return 0;
}
