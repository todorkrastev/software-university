#include <iostream>
#include <vector>
#include <cmath>

std::vector<double> getSquareRoots(int from, int to) {
    std::vector<double> roots;
    for (int i = from; i <= to; i++) {
        roots.push_back(sqrt(i));
    }

    return roots;
}

void print(std::vector<double> numbers) {
    for (int number : numbers) {
        std::cout << number << " ";
    }
    std::cout << std::endl;
}

int main() {
    print(getSquareRoots(4, 25));
    std::cerr << "Why is the output incorrect?" << std::endl;
    return 0;
}
