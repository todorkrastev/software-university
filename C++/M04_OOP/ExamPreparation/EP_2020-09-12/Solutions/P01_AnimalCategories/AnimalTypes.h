#ifndef CPP_ADVANCED_ANIMALTYPES_H
#define CPP_ADVANCED_ANIMALTYPES_H

#include "AnimalCharacteristics.h"

#include <map>
#include <vector>

class AnimalTypes {

  std::map<int, std::vector<AnimalCharacteristics>> animals;

public:

  AnimalTypes();

  void print() const;

  friend AnimalTypes& operator<<(AnimalTypes& animalTypes, const AnimalCharacteristics& characteristics);
};

#endif //CPP_ADVANCED_ANIMALTYPES_H
