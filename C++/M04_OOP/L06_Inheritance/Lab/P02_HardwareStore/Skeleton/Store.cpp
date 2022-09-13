#include "Store.h"

void Store::remove(const int index)
{
_laptops.erase  (_laptops.begin() + index);
}

void Store::copy(const int fromIndex,
                 const int toIndex)
{
_laptops[toIndex] = _laptops[fromIndex];
}

