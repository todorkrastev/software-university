#include <iostream>
#include <cmath>

int main() {
    const int numRoots = 100;
    double squareRoots[numRoots] = {};

    for (int i = 0; i < numRoots; i++) {
        squareRoots[i] = sqrt(i);
    }

    for (int i = 0; i < numRoots; i++) {
        std::cout << squareRoots[i] << std::endl;
    }

    return 0;
}
