#include <iostream>
#include <string>
#include <sstream>
#include "Store.h"

int main()
{
    Store store;
    std::string input;
    int inputSize = 0;

    std::cin >> inputSize;
    std::cin.ignore();

    for(int i = 0; i < inputSize; ++i)
    {
        getline(std::cin, input);
        std::istringstream sstr(input);
        std::string command;

        sstr >> command;

        if("buy" == command)
        {
            std::string name;
            double price = 0.0;
            double monitorSize = 0.0;

            sstr >> name >> price >> monitorSize;
            store.buy(name, price, monitorSize);
        }
        else if("remove" == command)
        {
            int index = 0;

            sstr >> index;
            store.remove(index);
        }
        else //"copy" == command
        {
            int indexFrom = 0;
            int indexTo = 0;

            sstr >> indexFrom >> indexTo;
            store.copy(indexFrom, indexTo);
        }
    }

    return 0;
}


