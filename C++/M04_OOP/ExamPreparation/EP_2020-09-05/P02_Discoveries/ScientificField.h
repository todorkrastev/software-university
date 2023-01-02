#ifndef CPP_ADVANCED_SCIENTIFICFIELD_H
#define CPP_ADVANCED_SCIENTIFICFIELD_H

#include "Discovery.h"

#include <unordered_map>
#include <vector>
#include <ostream>

class ScientificField {

  std::unordered_map<std::string, std::vector<Discovery>> discoveriesByField;

public:
  ScientificField();

  void print();

  friend ScientificField& operator<<(ScientificField& scientificField,
                                     const Discovery& discovery);
};

#endif //CPP_ADVANCED_SCIENTIFICFIELD_H
