#include "Food.h"

Food::Food() {}

void Food::cook(std::string type, std::string size, double price)
{
	this->orders.push_back(Order(type, size, price));
}

void Food::sell(int index)
{
	this->orders[index].printOrderInfo();
	std::cout << " is sold" << std::endl;
	this->orders.erase(this->orders.begin() + index);
}

void Food::copy(int indexFrom, int indexTo)
{
	if (indexFrom >= this->orders.size() || indexFrom < 0) {
		std::cout << "Invalid indexes" << std::endl;
	}
	else if (indexTo > this->orders.size() || indexTo < 0 || indexTo == indexFrom) {
		std::cout << "Invalid indexes" << std::endl;
	}
	else {
		if (indexTo == this->orders.size()) {
			Order order = Order();
			order = this->orders[indexFrom];
			this->orders.push_back(order);
		}
		else {
			this->orders[indexTo] = this->orders[indexFrom];
		}
		this->orders[indexFrom].printOrderInfo();
		std::cout << " is cooked" << std::endl;
	}
}
