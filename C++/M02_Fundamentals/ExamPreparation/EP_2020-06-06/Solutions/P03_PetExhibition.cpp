#include <iostream>
#include <vector>
#include <iterator>
#include <algorithm>

class Pet {
    std::string name;
    int age{ };
    double score{ };

    void init() {
        if (age >= 12) {
            score += 2.5;
        }
    }

public:
    double getScore() const {
        return score;
    }

    friend std::istream& operator>>(std::istream& is, Pet& pet) {
        is >> pet.name >> pet.age >> pet.score;
        pet.init();
        return is;
    }

    friend std::ostream& operator<<(std::ostream& os, const Pet& pet) {
        return os << pet.name;
    }

    bool operator>(const Pet& rhs) const {
        return score > rhs.score;
    }
};

int main() {
    size_t petsCount;
    std::cin >> petsCount;
    std::vector<Pet> pets(petsCount);
    std::copy_n(std::istream_iterator<Pet>(std::cin), petsCount, pets.begin());

    pets.erase(std::remove_if(pets.begin(), pets.end(), [](Pet& pet) {
        return pet.getScore() < 4.0;
        }), pets.end());

    std::sort(pets.begin(), pets.end(), std::greater<Pet>());

    std::copy(pets.cbegin(), pets.cend(), std::ostream_iterator<Pet>(std::cout, " "));

    return 0;
}