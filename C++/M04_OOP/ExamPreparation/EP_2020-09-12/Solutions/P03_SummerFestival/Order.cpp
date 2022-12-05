#include "Order.h"

Order::Order() : type(""), size(""), price(0) {}

Order::Order(std::string type, std::string size, double price)
	: type(type)
	, size(size)
	, price(price) {
	this->printOrderInfo();
	std::cout << " is cooked" << std::endl;
}

Order::Order(const Order& other)
{
	this->setType(other.getType());
	this->setSize(other.getSize());
	this->setPrice(other.getPrice());
}

std::string Order::getType() const
{
	return this->type;
}

std::string Order::getSize() const
{
	return this->size;
}

double Order::getPrice() const
{
	return this->price;
}

void Order::setType(std::string type)
{
	this->type = type;
}

void Order::setSize(std::string size)
{
	this->size = size;
}

void Order::setPrice(double price)
{
	this->price = price;
}

void Order::printOrderInfo()
{
	std::cout << "Food type: " << this->getType()
		<< ", size: " << this->getSize()
		<< ", price: " << this->getPrice();
}

Order& Order::operator = (const Order& other)
{
	if (this != &other)
	{
		this->setType(other.getType());
		this->setSize(other.getSize());
		this->setPrice(other.getPrice());
	}
	return *this;
}

Order::~Order() {}
