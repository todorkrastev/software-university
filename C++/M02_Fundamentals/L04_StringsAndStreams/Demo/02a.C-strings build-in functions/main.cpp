#include <iostream>
#include <cstring>

int main() {

    char line1[50] = {'h', 'e', 'l', 'l', 'o', ',', ' ','\0'};
    char line2[] = {'w', 'o', 'r', 'l', 'd', '!', '\0'};

    std::cout << "size of line1: " << strlen(line1) << std::endl;
    std::cout << "size of line2: " << strlen(line2) << std::endl;

    //NOTE line1 should be big enough to hold the concatenated string
    strcat(line1, line2);
    std::cout << line1 << std::endl;

    const int index = strstr(line1, "world!") - line1;
    std::cout << "world found at index: " << index << std::endl;

    return 0;
}
