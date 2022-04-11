#include <iostream>
#include <vector>

void print(std::vector<int> numbers) {
    for (int i = 0; i < numbers.size(); i++) {
      std::cout << numbers[i] << " ";
    }
    std::cout << std::endl;
}

void printMultiplied(std::vector<int> numbers, int multiplier) {
    for (int i = 0; i < numbers.size(); i++) {
        numbers[i] *= multiplier;
    }
    print(numbers);
}

int main() {
    std::vector<int> numbers {1, 2, 3};
    printMultiplied(numbers, 10); /// 10, 20, 30
    print(numbers); /// 1, 2, 3
    return 0;
}
