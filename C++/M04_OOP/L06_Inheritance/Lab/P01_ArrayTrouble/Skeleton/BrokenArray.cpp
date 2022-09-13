#include "BrokenArray.h"

BrokenArray::BrokenArray(const int arraySize)
{
    _array = new int[arraySize]{};
    _size = arraySize;
}

BrokenArray::~BrokenArray()
{
    delete[] _array;
}

BrokenArray::BrokenArray(const BrokenArray & other)
{
    _size = other._size;
}

BrokenArray & BrokenArray::operator=(const BrokenArray & other)
{
    _size = other._size;

    return *this;
}

void BrokenArray::addValueToMemory(const int value)
{
    for(int i = 0; i < _size; ++i)
    {
        _array[i] += value;
    }
}

int BrokenArray::getMemorySumValue() const
{
    int sum = 0;

    for(int i = 0; i < _size; ++i)
    {
        sum += _array[i];
    }

    return sum;
}

int BrokenArray::getSize() const
{
    return _size;
}


