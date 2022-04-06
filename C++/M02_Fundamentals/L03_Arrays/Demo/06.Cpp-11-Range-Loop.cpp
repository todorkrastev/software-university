#include <iostream>

int main() {
    int numbers[] = {13, 42, 69};

    //copy
    for (int number : numbers) {
        std::cout << number << ' ';
        ++number;
    }
    std::cout << "\n==================" << std::endl;

    for (int number : numbers) {
      std::cout << number << ' ';
    }
    std::cout << "\n==================" << std::endl;


    //reference
    for (int& number : numbers) {
        std::cout << number << ' ';
        ++number;
    }
    std::cout << "\n==================" << std::endl;

    for (int number : numbers) {
      std::cout << number << ' ';
    }


    return 0;
}
