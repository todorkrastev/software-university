#include "Discovery.h"
#include "Scientist.h"
#include <string>
#include <cstring>

Scientist::Scientist() : Scientist(nullptr, 0) {
}

Scientist::Scientist(char* name, int discoveriesCount) : name(strdup(name)),
                                                         discoveriesCount(discoveriesCount) {
}

Scientist::Scientist(const Scientist& other) : Scientist(other.name, other.discoveriesCount) {
}

Scientist& Scientist::operator=(const Scientist& other) {
  if (this != &other) {
    delete[] name;
    name = strdup(other.name);
    discoveriesCount = other.discoveriesCount;
  }

  return *this;
}

Scientist::~Scientist() {
  delete[] name;
}

char* Scientist::getName() const {
  return name;
}

int Scientist::getDiscoveriesCount() const {
  return discoveriesCount;
}

void Scientist::setName(const char* name) {
  delete[] this->name;
  this->name = strdup(name);
}

void Scientist::setDiscoveriesCount(int count) {
  discoveriesCount = count;
}

void Scientist::Print() const {

}
