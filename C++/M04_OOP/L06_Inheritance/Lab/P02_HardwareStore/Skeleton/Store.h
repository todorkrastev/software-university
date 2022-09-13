#ifndef STORE_H_
#define STORE_H_

#include <vector>
#include <string>
#include "Laptop.h"

class Store
{
    public:
        Store() = default;
        ~Store() = default;

        void buy(const std::string & name,
                 const double        price,
                 const double        monitorSize)
        {
            //emplace_back directly constructs object inside the container
            //without the need of making a temporary copy
            _laptops.emplace_back(name, price, monitorSize);
        }

        void remove(const int index);

        void copy(const int fromIndex,
                  const int toIndex);

    private:
        std::vector<Laptop> _laptops;
};

#endif /* STORE_H_ */
