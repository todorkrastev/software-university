#include <cmath>
#include <iomanip>
#include <iostream>
#include <map>
#include <sstream>
#include <string>

class Sale {
private:
	std::string town;
	std::string product;
	double price;
	double quantity;

public:
	void read(std::istream& istr);

	const std::string& getTown(void) const { return town; }
	const std::string& getProduct(void) const { return product; }
	double getPrice(void) const { return price; }
	double getQuantity(void) const { return quantity; }

	double totalSale(void) const { return price * quantity; }
};

void Sale::read(std::istream& istr) {
	istr >> town >> product >> price >> quantity;
}

int main() {

	Sale* Sales = NULL;

	size_t numberOfSales;
	std::cin >> numberOfSales;

	Sales = new Sale[numberOfSales];

	for (size_t curr = 0; curr < numberOfSales; curr++) {
		Sales[curr].read(std::cin);
	}

	typedef	std::map<std::string, double> TotalSalesMap;
	TotalSalesMap totalSales;

	for (size_t curr = 0; curr < numberOfSales; curr++) {
		const Sale& currSale = Sales[curr];
		totalSales[currSale.getTown()] += currSale.totalSale();

		std::cout << std::setprecision(2) << std::fixed;
	}

	for (TotalSalesMap::iterator it = totalSales.begin(); it != totalSales.end(); it++) {
		std::cout << it->first << " -> " << it->second << std::endl;
	}

	delete[] Sales;
	return 0;
}