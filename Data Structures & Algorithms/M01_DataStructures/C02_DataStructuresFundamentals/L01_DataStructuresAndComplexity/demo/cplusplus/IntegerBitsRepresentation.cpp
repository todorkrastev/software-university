#include <iostream>
#include <bitset>

int main() {
    int year = 2020;

    char* address = reinterpret_cast<char*>(&year);

    for (int i = 0; i < 4; ++i) {
        std::bitset<8> bits(*address);
        std::cout << "Bits located at: " << reinterpret_cast<int*>(address) << " => " << bits << std::endl;
        address++;
    }

    std::bitset<32> bits(year);

    std::cout << "Integer bits: " << bits << std::endl;
    address -= 4;
    std::cout << "Integer value: " << *reinterpret_cast<int*>(address) << std::endl;

    return 0;
}