#ifndef LAPTOP_H_
#define LAPTOP_H_

#include <iostream>
#include "Hardware.h"

class Laptop : public Hardware
{
    public:
        Laptop() = delete;

        Laptop(const std::string & name,
               const double        price,
               const double        monitorSize);

        virtual ~Laptop();

        Laptop(const Laptop & other);

        Laptop & operator=(const Laptop & other);

    private:
        void printInfo()
        {
            std::cout << "Model: " << getName() << ", price: " << getPrice()
                      << ", monitorSize: " << _monitorSize;;
        }

        double _monitorSize;
};

#endif /* LAPTOP_H_ */
