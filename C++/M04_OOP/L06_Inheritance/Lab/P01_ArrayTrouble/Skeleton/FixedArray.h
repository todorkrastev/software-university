#ifndef FIXEDARRAY_H_
#define FIXEDARRAY_H_

#include "BrokenArray.h"

class FixedArray : public BrokenArray
{
    public:
        FixedArray(const int arraySize);
        virtual ~FixedArray();

        FixedArray(const FixedArray & other);
        FixedArray & operator=(const FixedArray & other);

        void addValueToMemory(const int value);

        int getMemorySumValue() const;
};

#endif /* FIXEDARRAY_H_ */
