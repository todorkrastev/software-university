#include <iostream>

int main() {
    size_t size;
    std::cin >> size;

    long long sum = 0;

    for (int row = 0; row < size; ++row) {
        for (int col = 0; col < size; ++col) {
            int num;
            std::cin >> num;
            if (col + row != size - 1 && col != row && num % 2 != 0) {
                sum += num;
            }
        }
    }

    std::cout << "The sum is: " << sum << std::endl;

    return 0;
}