#include "ScientificField.h"

#include <algorithm>
#include <iostream>
#include <iterator>

static const std::unordered_map<int, std::string>& idToFieldName() {
  static const std::unordered_map<int, std::string> idToFieldName{
      { 1, "Philosophy" },
      { 2, "Linguistics" },
      { 3, "Physics" },
      { 4, "Chemistry" },
  };

  return idToFieldName;
}

static const std::vector<std::string>& fieldsPrintOrder() {
  static const std::vector<std::string> fieldsPrintOrder{
      "Physics",
      "Linguistics",
      "Philosophy",
      "Chemistry",
  };

  return fieldsPrintOrder;
}

static std::ostream& operator<<(std::ostream& ostream, const Discovery& discovery) {
  return ostream << discovery.name << " " << discovery.year << " - " << discovery.scientistName;
}

void ScientificField::print() {
  std::for_each(fieldsPrintOrder().cbegin(),
                fieldsPrintOrder().cend(),
                [this](const std::string& fieldName) {
                  std::cout << fieldName << ":" << std::endl;

                  std::sort(this->discoveriesByField.at(fieldName).begin(),
                            this->discoveriesByField.at(fieldName).end(),
                            [](const Discovery& lhs, const Discovery& rhr) {
                              return lhs.year < rhr.year;
                            });

                  std::copy(this->discoveriesByField.at(fieldName).cbegin(),
                            this->discoveriesByField.at(fieldName).cend(),
                            std::ostream_iterator<Discovery>(std::cout, "\n"));
                });
}

ScientificField& operator<<(ScientificField& scientificField, const Discovery& discovery) {
  const std::string& fieldName = idToFieldName().at(discovery.fieldType);
  scientificField.discoveriesByField.at(fieldName).emplace_back(discovery);

  return scientificField;
}

ScientificField::ScientificField() {
  std::for_each(fieldsPrintOrder().cbegin(),
                fieldsPrintOrder().cend(),
                [this](const std::string& fieldName) {
                  this->discoveriesByField[fieldName] = { };
                });
}
