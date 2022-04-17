#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>
#include <string>

class Drink {
    std::string name;
    double price;
    double rating;
public:

    void setPrice(double newPrice) {
        price = newPrice;
    }

    const std::string& getName() const {
        return name;
    }

    double getPrice() const {
        return price;
    }

    double getRating() const {
        return rating;
    }

    friend std::istream& operator>>(std::istream& is, Drink& drink);

    friend std::ostream& operator<<(std::ostream& os, const Drink& drink);
};

std::istream& operator>>(std::istream& is, Drink& drink) {
    getline(std::cin >> std::ws, drink.name);
    return is >> drink.price >> drink.rating;
}

std::ostream& operator<<(std::ostream& os, const Drink& coffee) {
    return os << coffee.name << ' ' << coffee.price;
}

class Cafe {
    std::vector<Drink> menu{ };
public:

    void deleteDrinksUnderRating(const double threshold) {
        menu.erase(
            std::remove_if(
                menu.begin(), menu.end(),
                [threshold](const Drink& drink) {
                    return drink.getRating() < threshold;
                }),
            menu.end());
    }

    void dropPriceForLowRating(const double threshold, const double priceMod) {
        std::for_each(
            menu.begin(), menu.end(),
            [&](Drink& drink) {
                if (drink.getRating() < threshold) {
                    drink.setPrice(drink.getPrice() * priceMod);
                }
            });
    }

    friend std::istream& operator>>(std::istream& is, Cafe& cafe);

    friend std::ostream& operator<<(std::ostream& os, const Cafe& cafe);
};

std::ostream& operator<<(std::ostream& os, const Cafe& cafe) {
    if (cafe.menu.empty()) {
        return os << "The menu is empty";
    }
    std::copy(cafe.menu.cbegin(), cafe.menu.cend(),
        std::ostream_iterator<Drink>(os, "\n"));
    return os;
}

std::istream& operator>>(std::istream& is, Cafe& cafe) {
    size_t coffeeCount;
    is >> coffeeCount;

    cafe.menu.resize(coffeeCount);

    std::copy_n(std::istream_iterator<Drink>{ is },
        coffeeCount,
        cafe.menu.begin());

    return is;
}

int main() {
    Cafe cafe{ };
    std::cin >> cafe;

    cafe.deleteDrinksUnderRating(4.0);
    cafe.dropPriceForLowRating(6.0, 0.9);

    std::cout << cafe;

    return 0;
}