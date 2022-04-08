#include <iostream>

int main() {
    char line1[4] = {'a', 'b', 'c'};
    char line2[] = {'d', 'e', 'f'};
    std::cout << line1 << std::endl;
    // NOTE: the behavior here is not defined by the standard (line2 is not null-terminated),
    // but due to the way memory for automatic variables is laid out,
    //this will probably print defabc
    std::cout << line2 << std::endl;

    return 0;
}
