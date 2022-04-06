#include <iostream>
#include <array>

const int arraySize = 3;

void printByCopy(std::array<int, arraySize> numbers) {
  for (int number : numbers) {
    std::cout << number << ' ';
  }
}

void printByReference(const std::array<int, arraySize>& numbers) {
  for (int number : numbers) {
    std::cout << number << ' ';
  }
}

int main() {
    std::array<int, arraySize> numbers = {13, 42, 69};

    //copy
    for (int number : numbers) {
        std::cout << number << ' ';
        ++number;
    }
    std::cout << "\n==================" << std::endl;

    printByCopy(numbers);
    std::cout << "\n==================" << std::endl;

    //reference
    for (int& number : numbers) {
        std::cout << number << ' ';
        ++number;
    }
    std::cout << "\n==================" << std::endl;

    printByReference(numbers);

    return 0;
}
