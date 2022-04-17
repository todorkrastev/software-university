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

// -------------------------------------------------------------------------------------------------

// Second option -> using Nested Map

// -------------------------------------------------------------------------------------------------

#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <algorithm>


int main() {

	std::map<std::string, std::map<int, double>> pets;
	int num;
	std::cin >> num;

	std::string name;
	int age = 0;
	double score = 0.0;
	for (size_t i = 0; i < num; i++) {
		std::cin >> name >> age >> score;

		if (12 <= age) {
			score += 2.5;
		}

		if (score < 4) {
			continue;
		}

		pets[name][0] = age;
		pets[name][1] = score;
	}

	
	std::map<std::string, double> newMap;
	for (auto& pet : pets) {
		newMap[pet.first] = pet.second[1];
	}

	std::vector<std::pair<std::string, double>> vector;
	for (auto& pet : newMap) {
		vector.emplace_back(pet);
	}
	
	sort(vector.begin(), vector.end(),
		[](const auto& x, const auto& y) {return y.second < x.second; });
	
	for (auto& name : vector) {
		std::cout << name.first << " ";
	}

	return 0;
}
