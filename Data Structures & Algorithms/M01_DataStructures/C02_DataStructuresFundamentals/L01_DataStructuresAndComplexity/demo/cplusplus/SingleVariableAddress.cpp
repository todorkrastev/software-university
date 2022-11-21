#include <iostream>

int main() {
    int number = 42;

    int* address = &number;

    std::cout << "Variable located at address: " << address << std::endl;
    std::cout << "Integer value: " << *address << std::endl;

    return 0;
}