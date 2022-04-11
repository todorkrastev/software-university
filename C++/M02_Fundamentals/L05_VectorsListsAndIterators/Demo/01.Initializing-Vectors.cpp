#include <iostream>
#include <vector>
#include <cmath>

int main() {
    std::vector<double> squareRoots;

    for (int i = 0; i < 100; i++) {
        squareRoots.push_back(sqrt(i));
    }

    std::vector<char> letters {'x', 'y', 'z'};
    std::vector<char> otherLetters = {'x', 'y', 'z'};

    return 0;
}
