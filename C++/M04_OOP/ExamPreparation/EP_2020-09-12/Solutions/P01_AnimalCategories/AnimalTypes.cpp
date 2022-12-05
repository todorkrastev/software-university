#include "AnimalTypes.h"
#include "AnimalCategories.h"
#include <iostream>
#include <algorithm>
#include <iterator>

static std::ostream& operator<<(std::ostream& os, const AnimalCharacteristics& characteristics) {
  return os << characteristics.name << " - " << characteristics.breed << " - " << characteristics.age;
}

void AnimalTypes::print() const {
  using namespace categories;
  for (int category = AnimalCategoryBegin; category < AnimalCategoryEnd; ++category) {
    std::cout << categoryIdToName(category) << " Breeds:" << std::endl;
    std::copy(this->animals.at(category).cbegin(), this->animals.at(category).cend(),
              std::ostream_iterator<AnimalCharacteristics>(std::cout, "\n"));
  }
}

AnimalTypes& operator<<(AnimalTypes& animalTypes, const AnimalCharacteristics& animal) {
  animalTypes.animals[animal.category].emplace_back(animal);
  return animalTypes;
}

AnimalTypes::AnimalTypes() {
  using namespace categories;
  for (int category = AnimalCategoryBegin; category < AnimalCategoryEnd; ++category) {
    this->animals[category] = { };
  }
}
