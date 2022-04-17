#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <algorithm>
#include <numeric>


int main() {

	std::map<std::string, double> items;

	int num, counter;
	std::string name;
	double price;

	std::cin >> num;

	for (size_t i = 0; i < num; i++) {
		std::cin >> name >> price >> counter;

		items[name] += price * counter;
	}

	double totalSum = 0.0;

	std::vector<std::pair<std::string, double>> vector;
	for (auto& item : items) {
		vector.emplace_back(item);
		totalSum += item.second;
	}

	sort(vector.begin(), vector.end(),
		[](const auto& x, const auto& y) {return y.second < x.second; });


	std::cout << "The total sum is: " << totalSum << " lv." << std::endl;

	for (auto& item : vector) {
		std::cout << item.first << " " << item.second << std::endl;
	}

	return 0;
}

// -------------------------------------------------------------------------

// refactoring

// -------------------------------------------------------------------------

#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>
#include <numeric>

struct Item {
	std::string name{ };
	double price{ };
	int quantity{ };

	double totalPrice() const {
		return price * quantity;
	}

	bool operator<(const Item& other) const {
		return totalPrice() > other.totalPrice();
	}
};

std::ostream& operator<<(std::ostream& os, const Item& item) {
	return os << item.name << ' ' << item.totalPrice();
}

std::istream& operator>>(std::istream& is, Item& item) {
	return is >> item.name >> item.price >> item.quantity;
}

int main() {
	size_t itemsCount;
	std::cin >> itemsCount;
	std::vector<Item> items(itemsCount);

	for (size_t i = 0; i < itemsCount; ++i) {
		std::cin >> items[i];
	}

	double totalSum = std::accumulate(
		items.cbegin(), items.cend(), 0.0,
		[](double acc, const Item& item) {
			return acc + item.totalPrice();
		});

	std::cout << "The total sum is: " << totalSum << " lv." << std::endl;

	std::sort(items.begin(), items.end());

	std::move(items.begin(), items.end(),
		std::ostream_iterator<Item>(std::cout, "\n"));

	return 0;
}