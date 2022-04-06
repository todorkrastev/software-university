#include <iostream>

void print(int* arr, int arrSize) {
    for (int i = 0; i < arrSize; i++) {
        std::cout << arr[i] << " ";
    }

    std::cout << std::endl;
}

int main() {
    const int numbersLength = 3;
    int numbers[numbersLength] = {1,2,3};

    int* arrPtr = numbers;

    print(numbers, numbersLength);
    print(arrPtr, 3);

    std::cout << "arrPtr: " << arrPtr << std::endl;
    std::cout << "arrPtr[0]: " << arrPtr[0] << std::endl;
    std::cout << "&arrPtr[0]: " << &arrPtr[0] << std::endl;
    std::cout << "arrPtr[1]: " << arrPtr[1] << std::endl;
    std::cout << "&arrPtr[1]: " << &arrPtr[1] << std::endl;

    return 0;
}
