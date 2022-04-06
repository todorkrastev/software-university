#include <iostream>

void print(int arr[], int arrSize) {
    for (int i = 0; i < arrSize; i++) {
        std::cout << arr[i] << " ";
    }

    std::cout << std::endl;
}

int main() {
    const int numbersLength = 3;
    int numbers[numbersLength] = {1,2,3};

    print(numbers, numbersLength);
    print(numbers, 3);

    return 0;
}
