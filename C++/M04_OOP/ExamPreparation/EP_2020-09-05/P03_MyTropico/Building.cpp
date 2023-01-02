#include "Building.h"

int Building::getWidth() const {
    return this->width;
}

int Building::getLength() const {
    return this->length;
}

Building::Building(int width, int length)
    : width(width)
    , length(length) { }
