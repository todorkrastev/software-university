#ifndef HARDWARE_H_
#define HARDWARE_H_

#include <string>

class Hardware
{
    public:
        Hardware() = delete;
        virtual ~Hardware() = default;

        Hardware(const std::string & name, const double price) : _name(name),
                                                                 _price(price)
        {
        }

        Hardware(const Hardware & other) = default;
        Hardware & operator=(const Hardware & other) = default;

    protected:

        std::string getName() const
        {
            return _name;
        }

        double getPrice() const
        {
            return _price;
        }

    private:
        std::string _name;
        double      _price;
};

#endif /* HARDWARE_H_ */
