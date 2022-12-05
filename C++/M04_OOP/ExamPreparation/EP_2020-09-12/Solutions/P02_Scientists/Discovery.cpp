#include "Scientist.h"
#include "Discovery.h"
#include <cstring>

Discovery::Discovery() { }

Discovery::Discovery(const char* discoveryName, int year, const Scientist& scientistName, Fields fieldOfStudy)
    : discoveryName(strdup(discoveryName)),
      year(year),
      scientist(scientistName),
      fieldOfStudy(fieldOfStudy) { }

Discovery::Discovery(const Discovery& other) : Discovery(other.discoveryName,
                                                         other.year,
                                                         other.scientist,
                                                         other.fieldOfStudy) { }

char* Discovery::getDiscoveryName() const {
  return discoveryName;
}

int Discovery::getYear() const {
  return year;
}

Scientist Discovery::getScientist() const {
  return scientist;
}

Fields Discovery::getFieldOfStudy() const {
  return fieldOfStudy;
}

void Discovery::setDiscoveryName(const char* name) {
  delete[] discoveryName;
  discoveryName = strdup(name);
}

void Discovery::setYear(int year) {
  this->year = year;
}

void Discovery::setScientist(const Scientist& author) {
  scientist = author;
}

void Discovery::setFieldOfStudy(Fields fieldOfStudy) {
  this->fieldOfStudy = fieldOfStudy;
}

char* Discovery::getScientistName() const {
  return scientist.getName();
}

Discovery& Discovery::operator=(const Discovery& other) {
  if (this != &other) {
    delete[] discoveryName;
    discoveryName = strdup(other.discoveryName);
    year = other.year;
    scientist = other.scientist;
    fieldOfStudy = other.fieldOfStudy;
  }

  return *this;
}

Discovery::~Discovery() {
  delete[] discoveryName;
}
