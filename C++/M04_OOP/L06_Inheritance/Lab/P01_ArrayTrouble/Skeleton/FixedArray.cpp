#include "FixedArray.h"

FixedArray::FixedArray(const int arraySize) : BrokenArray(arraySize)
{

}

FixedArray::~FixedArray()
{

}

FixedArray::FixedArray(const FixedArray & other) : BrokenArray(other)
{
    const int SIZE = BrokenArray::getSize();

    _array = new int[SIZE]{};

    for(int i = 0; i < SIZE; ++i)
    {
        _array[i] = other._array[i];
    }
}

FixedArray & FixedArray::operator=(const FixedArray & other)
{
    if(this != &other)
    {
        if(_array)
        {
            delete[] _array;
        }

        BrokenArray::operator =(other);

        const int SIZE = BrokenArray::getSize();

        _array = new int[SIZE]{};

        for(int i = 0; i < SIZE; ++i)
        {
            _array[i] = other._array[i];
        }
    }

    return *this;
}

void FixedArray::addValueToMemory(const int value)
{
    BrokenArray::addValueToMemory(value);
}

int FixedArray::getMemorySumValue() const
{
    return BrokenArray::getMemorySumValue();
}
