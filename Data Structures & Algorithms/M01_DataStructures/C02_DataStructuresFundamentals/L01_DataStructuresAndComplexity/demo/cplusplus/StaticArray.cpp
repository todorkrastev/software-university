#include <iostream>

int main() {

    int arr[] = {13, 42, 69};

    int* firstElementAddress = &arr[0];
    char* firstElementAsSingleByte = reinterpret_cast<char*>(&arr[0]);

    for (size_t i = 0; i < sizeof(arr) / sizeof(int); ++i) {
        std::cout << "Element access by using index: " <<  arr[i] << std::endl;
        std::cout << "Element access by using pointer: " << *firstElementAddress << std::endl;
        firstElementAddress++;
        std::cout << "Element access by using formula: " << static_cast<int>(
                *(firstElementAsSingleByte + i * sizeof(int))) << std::endl;
        std::cout << "Located at: " << &arr[i] << std::endl;
    }


    return 0;
}