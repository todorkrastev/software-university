#ifndef BROKENARRAY_H_
#define BROKENARRAY_H_

class BrokenArray
{
    public:
        BrokenArray(const int arraySize);
        virtual ~BrokenArray();

        BrokenArray(const BrokenArray & other);
        BrokenArray & operator=(const BrokenArray & other);

        //forbid the move constructor/move assignment operators
        BrokenArray(const BrokenArray && movedOther) = delete;
        BrokenArray & operator=(const BrokenArray && movedOther) = delete;

    protected:
        void addValueToMemory(const int value);

        int getMemorySumValue() const;

        int getSize() const;

        int * _array;

    private:
        int   _size;
};

#endif /* BROKENARRAY_H_ */
