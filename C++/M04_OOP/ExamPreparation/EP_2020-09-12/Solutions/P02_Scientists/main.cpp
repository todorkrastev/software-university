#include "Discovery.h"
#include "Scientist.h"

#include <iostream>
#include <cstring>
#include <vector>
#include <unordered_map>
#include <algorithm>

void initData(std::vector<Discovery>& discoveries, std::vector<Scientist>& scientists);

void printDiscoveries(std::vector<Discovery>& discoveries);

static Fields stringToField(const std::string& fieldName);

int main() {
  std::vector<Discovery> discoveries{ };
  std::vector<Scientist> scientists{ };

  initData(discoveries, scientists);

  printDiscoveries(discoveries);

  return 0;
}

void printDiscoveries(std::vector<Discovery>& discoveries) {
  std::sort(discoveries.begin(), discoveries.end(),
            [](const Discovery& lhs, const Discovery& rhs) {
              return lhs.getYear() < rhs.getYear();
            });

  std::for_each(discoveries.cbegin(), discoveries.cend(),
                [](const Discovery& discovery) {
                  std::cout << discovery.getDiscoveryName() << " - "
                            << discovery.getScientistName() << " - "
                            << discovery.getFieldOfStudy() << std::endl;
                });
}

void initData(std::vector<Discovery>& discoveries,
              std::vector<Scientist>& scientists) {
  int scientistsCount = 0;
  std::cin >> scientistsCount;

  for (int i = 0; i < scientistsCount; ++i) {
    std::string scientistName;
    std::cin >> scientistName;

    int discoveriesCount;
    std::cin >> discoveriesCount;

    Scientist scientist{ strdup(scientistName.c_str()), discoveriesCount };
    scientists.push_back(scientist);

    for (int j = 0; j < discoveriesCount; ++j) {
      std::string discoveryName, fieldName;
      int year;
      std::cin >> discoveryName >> year >> fieldName;

      discoveries.emplace_back(strdup(discoveryName.c_str()),
                               year,
                               scientist,
                               stringToField(fieldName));
    }
  }
}

static Fields stringToField(const std::string& fieldName) {
  static const std::unordered_map<std::string, Fields> stringToField{
      { "Chemistry",   Chemistry },
      { "Physics",     Physics },
      { "Linguistics", Linguistics },
      { "Philosophy",  Philosophy },
  };

  return stringToField.at(fieldName);
}
